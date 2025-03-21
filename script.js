const taskForm = document.getElementById('task-form');
const taskInput = document.getElementById('task-input');
const taskList = document.getElementById('task-list');

taskForm.addEventListener('submit', function (e) {
  e.preventDefault();
  const taskText = taskInput.value.trim();
  if (taskText !== "") {
    addTask(taskText);
    taskInput.value = '';
  }
});

function addTask(text) {
  const li = document.createElement('li');
  li.innerHTML = `
    <span>${text}</span>
    <button class="task-status" onclick="toggleStatus(this)">Pending</button>
  `;
  taskList.appendChild(li);
}

function toggleStatus(btn) {
  if (btn.classList.contains('done')) {
    btn.classList.remove('done');
    btn.innerText = 'Pending';
  } else {
    btn.classList.add('done');
    btn.innerText = 'Done';
  }
}