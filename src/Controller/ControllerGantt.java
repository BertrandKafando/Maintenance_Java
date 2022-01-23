package Controller;

import com.sun.org.apache.xpath.internal.operations.Or;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import metier.Intervenant;
import metier.MetierImpl;
import metier.OrdreTravail;

import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import static Controller.ControllerResponsable.liste;

public class ControllerGantt implements Initializable {
    @FXML
    private StackedBarChart<Number,String> gantt;
    @FXML
   private CategoryAxis yy;
    @FXML
    private NumberAxis xx;
MetierImpl imp=new MetierImpl();
    List<OrdreTravail>trs=imp.getAllOrdreTravail();
    @Override
    public void initialize(URL location, ResourceBundle resources) {

      rafraichir();
        /*
        while (it.hasNext()){
            XYChart.Series<Number, String> dataSeries1 = new XYChart.Series<Number, String>();
            dataSeries1.setName("ord"+i++);
            dataSeries1.getData().add(new XYChart.Data<Number, String>(it.next().getTemps(),it.next().getIntervenant().getNom()));
            gantt.getData().add(dataSeries1);
            System.out.println(1);;
        }*/

      }
      public void rafraichir(){

        trs.clear();
        trs= imp.getAllOrdreTravail();
          gantt.getData().clear();
          List<OrdreTravail > ordres=imp.getAllOrdreTravail();
          List<Intervenant> intervenants=imp.getAllInter();

      /*
      for(int i=0;i<intervenants.size();i++){
          XYChart.Series<Number, String> dataSeries1 = new XYChart.Series<Number, String>();
          dataSeries1.setName("ordr");
          //recuper les ordres de travail d'un intervenants et les afficher
          List<OrdreTravail> travails=imp.getOrdreTravailIntervenant(intervenants.get(i));
          Iterator<OrdreTravail> it=travails.iterator();
          while (it.hasNext()){
              dataSeries1.getData().add(new XYChart.Data<>(it.next().getTemps(),intervenants.get(i).getNom()));
              gantt.getData().add(dataSeries1);
          }


       */
          Iterator<OrdreTravail> it=trs.iterator();
          int i=0;
          for (int j=0;j<trs.size();j++){
              XYChart.Series<Number, String> dataSeries1 = new XYChart.Series<Number, String>();
              dataSeries1.setName("ordre du "+trs.get(i).getDate());
              dataSeries1.getData().add(new XYChart.Data<Number, String>(trs.get(j).getTemps(),trs.get(j).getIntervenant().getNom()));
              gantt.getData().add(dataSeries1);
              System.out.println(j);
          }
      }
/*
        XYChart.Series<Number, String> dataSeries1 = new XYChart.Series<Number, String>();
        dataSeries1.setName("2014");

        dataSeries1.getData().add(new XYChart.Data<Number, String>(20.973, "Java"));
        dataSeries1.getData().add(new XYChart.Data<Number, String>(4.429, "C#"));
        dataSeries1.getData().add(new XYChart.Data<Number, String>(2.792, "PHP"));

        // Series 2 - Data of 2015
        XYChart.Series<Number, String> dataSeries2 = new XYChart.Series<Number, String>();
        dataSeries2.setName("2015");

        dataSeries2.getData().add(new XYChart.Data<Number, String>(26.983, "Java"));
        dataSeries2.getData().add(new XYChart.Data<Number, String>(6.569, "C#"));
        dataSeries2.getData().add(new XYChart.Data<Number, String>(6.619, "PHP"));

        // Add Series to BarChart.
        gantt.getData().add(dataSeries1);
        gantt.getData().add(dataSeries2);
*/
    }

