package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class MainController {
	
	@FXML
	private Button btn1;

	@FXML
	private Button btn2;

	@FXML
	private ListView listview;
	
	@FXML
	private ImageView imageView;
	
	public void Button1Action(ActionEvent event) {
		FileChooser fc = new FileChooser();
		fc.setInitialDirectory(new File("C:\\Users\\BRUROB00\\Documents\\MATLAB"));
		fc.getExtensionFilters().addAll(new ExtensionFilter("PNG Files", "*.png"));
		File selectedFile =fc.showOpenDialog(null);
		
		try {
			 //creating the image object
			InputStream stream = new FileInputStream(selectedFile);
			Image image = new Image(stream);
			  //Creating the image view
			imageView.setImage(image);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("file is not found");
			e.printStackTrace();
		}
		
		if (selectedFile != null) {
			listview.getItems().add(selectedFile.getAbsolutePath());
		}else{
			System.out.println("file is not valid");
		}
	}
	
	public void Button2Action(ActionEvent event) {
		FileChooser fc = new FileChooser();
		fc.setInitialDirectory(new File("C:\\Users\\BRUROB00\\Documents\\MATLAB"));
		fc.getExtensionFilters().addAll(new ExtensionFilter("PDF Files", "*.pdf"));
		List<File> selectedFiles =fc.showOpenMultipleDialog(null);
		
		if (selectedFiles != null) {
			for(int i=0;i < selectedFiles.size(); i++) {
				listview.getItems().add(selectedFiles.get(i).getAbsolutePath());
			}
		}else{
			System.out.println("file is not valid");
		}
	}
}
