'use strict';
document.getElementById('addTodo').addEventListener('click', async ()=> {
    const input = document.getElementById('name');
    const title = input.value;
    if (title) {
        const res = await fetch('https://jsonplaceholder.typicode.com/todos',
            {method:'POST',
            headers:{
                'Content-Type':'application/json'
            },
            body:JSON.stringify({title, comleted:false})
            });
        const todo = await res.json();
        console.log(todo);
        todoToHtml(todo);
        input.value = " ";

    }
})
    async function getAll() {
        const res = await fetch('https://jsonplaceholder.typicode.com/todos?_limit=10');
        const todos = await res.json();
        console.log(todos);
        todos.forEach(todo => todoToHtml(todo))
    }

    window.addEventListener('DOMContentLoaded', getAll);

    function todoToHtml({id, completed, title}) {
        const todoList = document.getElementById('todos');
        todoList.insertAdjacentHTML('beforeend', `
        <div class="form-check" id="todo${id}">
        <label class= "form-check-label" >
        <input type = "checkbox" class = "check-box-input" ${completed && 'checked'}>
        ${title}
    </label>
    <button type="button" class="btn-close" style="font-size: 10px" disabled aria-label="Close"></button>
</div>
       `)

}