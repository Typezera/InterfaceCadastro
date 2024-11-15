module org.example.interfacecadastro {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.google.gson;

    opens org.example.interfacecadastro to javafx.fxml;
    exports org.example.interfacecadastro;
}