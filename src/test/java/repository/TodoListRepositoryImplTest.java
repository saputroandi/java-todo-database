package repository;

import com.zaxxer.hikari.HikariDataSource;
import entity.TodoList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.DatabaseUtil;

public class TodoListRepositoryImplTest {

    private HikariDataSource dataSource;
    private TodoListRepositoryImpl todoListRepository;

    @BeforeEach
    void setUp() {
        dataSource = DatabaseUtil.getHikariDataSource();
        todoListRepository = new TodoListRepositoryImpl(dataSource);
    }

    @Test
    void testAdd() {

        TodoList todoList = new TodoList();
        todoList.setTodo("andi belajar java");

        todoListRepository.add(todoList);

    }

    @Test
    void testRemove() {

        System.out.println(todoListRepository.remove(1));
        System.out.println(todoListRepository.remove(2));
        System.out.println(todoListRepository.remove(3));

    }

    @Test
    void testGetAll() {

        todoListRepository.add(new TodoList("Andi"));
        todoListRepository.add(new TodoList("Saputro"));

        TodoList[] todoList = todoListRepository.getAll();

        for (var todo : todoList) {
            System.out.println(todo.getId() + ":" + todo.getTodo());
        }

    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }
}
