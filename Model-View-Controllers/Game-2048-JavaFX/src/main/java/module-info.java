module org.example.game2048javafx {
  requires javafx.controls;
  requires javafx.fxml;


  opens org.example.game2048javafx to javafx.fxml;
  exports org.example.game2048javafx;
}