package service;

import entity.TodoList;
import repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService {

    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {
        TodoList[] models = todoListRepository.getAll();

        System.out.println("TODOLIST");

        for (var todo : models) {
            System.out.println(todo.getId() + ":" + todo.getTodo());
        }

    }

    @Override
    public void addTodoList(String todo) {
        TodoList todoList = new TodoList(todo);

        todoListRepository.add(todoList);
    }

    @Override
    public void removeTodoList(Integer number) {
        boolean success = todoListRepository.remove(number);

        if (success) {
            System.out.println("berhasil menghapus todo: " + number);
        } else {
            System.out.println("gagal menghapus todo: " + number);
        }
    }
}
