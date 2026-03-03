async function loadTasks() {
  const res = await fetch("/api/tasks");
  const tasks = await res.json();

  const list = document.getElementById("tasks");
  list.innerHTML = "";

  for (const t of tasks) {
    const li = document.createElement("li");
    li.textContent = `${t.title} ${t.completed ? "✅" : ""}`;
    list.appendChild(li);
  }
}

document.getElementById("createForm").addEventListener("submit", async (e) => {
  e.preventDefault();
  const title = document.getElementById("title").value.trim();
  if (!title) return;

  await fetch("/api/tasks", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ title, description: "", completed: false })
  });

  document.getElementById("title").value = "";
  await loadTasks();
});

loadTasks();