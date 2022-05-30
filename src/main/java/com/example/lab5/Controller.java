package com.example.lab5;

import com.example.lab5.books.creator.BookFactory;
import com.example.lab5.books.creator.CreateB;
import com.example.lab5.books.classes.Book;
import com.example.lab5.books.classes.eng.EngEd;
import com.example.lab5.books.classes.eng.EngFic;
import com.example.lab5.books.classes.rus.RusFic;
import com.example.lab5.users.classes.User;
import com.example.lab5.users.creator.CreateArr;
import com.example.lab5.users.creator.UserFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.ArrayList;

public class Controller {

    int numBooks = 250;

    ArrayList<User> users = new ArrayList<>();
    ArrayList<Book> books = new ArrayList<>();

    @FXML
    private TreeView<String> tree;

//    @FXML
//    private Button buttonUser;
//
//    public void initialize() {
//        buttonUser.setDisable(true);
//    }


    @FXML
    void importBook(ActionEvent event) {
        try {
            FileChooser chooser = new FileChooser();
            File file = chooser.showOpenDialog(null);
            CreateB createB = new CreateB();
            createB.setAll(file);
            BookFactory bFactory = new BookFactory(createB);
            for (int i = 0; i < numBooks; i++) {
                books.add(bFactory.createBook());
            }

//            buttonUser.setDisable(false);
        } catch (Exception e) {
            error(e);
        }
    }

    @FXML
    void impUser(ActionEvent event) {
        try {
            FileChooser chooser = new FileChooser();
            File file = chooser.showOpenDialog(null);
            CreateArr impU = new CreateArr();
            impU.setAll(file);
            UserFactory userFactory = new UserFactory(impU);
            users = userFactory.createProf(books);
            initializeTree();

        } catch (Exception e) {
            error(e);
        }
    }

    @FXML

    public void initializeTree() {

        int stNum = 0;
        int prNum = 0;

        TreeItem<String> rootItem = new TreeItem<>("Пользователи");
        rootItem.setExpanded(true);
        TreeItem<String> studentItem = new TreeItem<>();
        rootItem.getChildren().add(studentItem);
        TreeItem<String> professorItem = new TreeItem<>();
        rootItem.getChildren().add(professorItem);

        for (User user : users) {

            TreeItem<String> branchItem = new TreeItem<>(user.getFullName() + " (" + user.getBooks().size() + ")");
            if (user.getClass().getName().equals("com.example.lab5.users.classes.Student")) {
                studentItem.getChildren().add(branchItem);
                stNum++;
            } else {
                professorItem.getChildren().add(branchItem);
                prNum++;
            }

            user.getBooks().forEach((obj) -> {
                Book book = (Book) obj;

                TreeItem<String> bookItem = new TreeItem<>(book.getName());
                branchItem.getChildren().add(bookItem);
                TreeItem<String> leafType = new TreeItem<>("Тип: " + book.getType());
                bookItem.getChildren().add(leafType);
                TreeItem<String> leafLang = new TreeItem<>("Язык: " + book.getLang());
                bookItem.getChildren().add(leafLang);

                if (book.getClass().getName().equals("com.example.lab5.books.classes.eng.EngEd")) {
                    EngEd b = (EngEd) book;
                    TreeItem<String> leafAuthor = new TreeItem<>("Автор: " + b.getAuthor());
                    bookItem.getChildren().add(leafAuthor);
                    TreeItem<String> leafUniversity = new TreeItem<>("Университет: " + b.getUniversity());
                    bookItem.getChildren().add(leafUniversity);
                    TreeItem<String> leafLvl = new TreeItem<>("Уровень: "+b.getLvl());
                    bookItem.getChildren().add(leafLvl);
                } else if (book.getClass().getName().equals("com.example.lab5.books.classes.eng.EngFic")) {
                    EngFic b = (EngFic) book;
                    TreeItem<String> leafAuthor = new TreeItem<>("Автор: " + b.getAuthor());
                    bookItem.getChildren().add(leafAuthor);
                } else if (book.getClass().getName().equals("com.example.lab5.books.classes.rus.RusFic")) {
                    RusFic b = (RusFic) book;
                    TreeItem<String> leafAuthor = new TreeItem<>("Автор: " + b.getAuthor());
                    bookItem.getChildren().add(leafAuthor);
                }

            });

        }

        studentItem.setValue("Студенты (" + stNum + ")");
        professorItem.setValue("Преподаватели (" + prNum + ")");

        tree.setRoot(rootItem);

    }
    void error(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(e.getMessage());
        alert.showAndWait();
    }

}
