module com.example.knk2425 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.apache.commons.codec;

    opens com.example.knk2425 to javafx.fxml;
    exports com.example.knk2425;


    opens group_01.java_01 to javafx.fxml;
    opens group_01.java_02 to javafx.fxml;
    opens group_01.java_03 to javafx.fxml;
    opens group_01.java_04 to javafx.fxml;
    opens group_01.java_09 to javafx.fxml;


    opens group_02.java_01 to javafx.fxml;
    opens group_02.java_02 to javafx.fxml;
    opens group_02.java_03 to javafx.fxml;
    opens group_02.java_04 to javafx.fxml;
    opens group_02.java_09 to javafx.fxml;

    opens group_03.java_01 to javafx.fxml;
    opens group_03.java_02 to javafx.fxml;
    opens group_03.java_03 to javafx.fxml;
    opens group_03.java_04 to javafx.fxml;
    opens group_03.java_09 to javafx.fxml;

    exports group_01.java_01;
    exports group_01.java_02;
    exports group_01.java_03;
    exports group_01.java_04;
    exports group_01.java_09;

    exports group_02.java_01;
    exports group_02.java_02;
    exports group_02.java_03;
    exports group_02.java_04;
    exports group_02.java_09;

    exports group_03.java_01;
    exports group_03.java_02;
    exports group_03.java_03;
    exports group_03.java_04;
    exports group_03.java_09;

    opens controllers to javafx.fxml;
    exports controllers;
}