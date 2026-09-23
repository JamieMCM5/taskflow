async function loadTasks() {
  const res = await fetch("/api/tasks");
  const tasks = await res.json();

  const list = document.getElementById("tasks");
  list.innerHTML = "";

  for (const t of tasks) {
    const li = document.createElement("li");

    const taskContent = document.createElement("div");
    taskContent.className = "task-content";

    const title = document.createElement("h3");
    title.textContent = t.title;

    const description = document.createElement("p");
    description.textContent = t.description || "No description";

    const created = document.createElement("small");
    created.textContent = "Created: " + new Date(t.createdAt).toLocaleString();

    taskContent.appendChild(title);
    taskContent.appendChild(description);
    taskContent.appendChild(created);

    const deleteButton = document.createElement("button");
    deleteButton.textContent = "Delete";
    deleteButton.addEventListener("click", () => deleteTask(t.id));

    const completedCheckbox = document.createElement("input");
    completedCheckbox.type = "checkbox";
    completedCheckbox.checked = t.completed;
    completedCheckbox.addEventListener("change", async () => {
      await fetch(`/api/tasks/${t.id}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ ...t, completed: completedCheckbox.checked })
      });
    });

    li.appendChild(taskContent);
    li.appendChild(deleteButton);
    li.appendChild(completedCheckbox);
    list.appendChild(li);
  }
}

async function deleteTask(id) {
  const confirmed = window.confirm(`Are you sure you want to delete this task?`);

  if (!confirmed) return;

  const response = await fetch(`/api/tasks/${id}?confirm=true`, {
    method: "DELETE"
  });

  if (!response.ok) {
    alert("Failed to delete task. Please try again.");
    return;
  }

  await loadTasks();
}

document.getElementById("createForm").addEventListener("submit", async (e) => {
  e.preventDefault();
  const title = document.getElementById("title").value.trim();
  const description = document.getElementById("description").value.trim();
  if (!title) return;

  await fetch("/api/tasks", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ title, description, completed: false})
  });

  await loadTasks();
});

loadTasks();