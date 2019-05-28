import com.github.lgooddatepicker.components.CalendarPanel;
import com.github.lgooddatepicker.zinternaltools.DemoPanel;
import com.github.lgooddatepicker.components.DatePicker;
import javax.swing.JFrame;
import java.util.Locale;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.zinternaltools.InternalUtilities;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.github.lgooddatepicker.components.TimePicker;
import com.privatejgoodies.forms.factories.CC;
import javax.swing.border.LineBorder;
import java.time.LocalDate;

/**
 * FullDemo, This class contains a demonstration of various features of the DatePicker library
 * components.
 *
 * Optional features: Most of the features shown in this demo are optional. The simplest usage only
 * requires creating a date picker instance and adding it to a panel or window. The selected date
 * can then be retrieved with the function datePicker.getDate(). For a simpler demo, see
 * "BasicDemo.java".
 *
 * Running the demo: This is an executable demonstration. To run the demo, click "run file" (or the
 * equivalent command) for the class in your IDE.
 */
public class FullDemo {

    // This holds our main frame.
    static JFrame frame;
    // This holds our display panel.
    static DemoPanel panel;
    // These hold date pickers.
    static DatePicker datePicker;
    static DatePicker datePicker1;
    static DatePicker datePicker2;
    // These hold time pickers.
    static TimePicker timePicker;
    static TimePicker timePicker1;
    static TimePicker timePicker2;
    // These hold DateTimePickers.
    static DateTimePicker dateTimePicker1;
    static DateTimePicker dateTimePicker2;
    static DateTimePicker dateTimePicker3;
    static DateTimePicker dateTimePicker4;
    static DateTimePicker dateTimePicker5;
    // Date pickers are placed on the rows at a set interval.
    static final int rowMultiplier = 4;

    /**
     * main, The application entry point.
     */
    public static void main(String[] args) { 
        ///////////////////////////////////////////////////////////////////////////////////////////
        // Create a frame, a panel, and our demo buttons.
        frame = new JFrame();
        frame.setTitle("LGoodDatePicker Demo " + InternalUtilities.getProjectVersionString());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new DemoPanel();
        frame.getContentPane().add(panel); 
 
        ///////////////////////////////////////////////////////////////////////////////////////////
        // This section creates any remaining DateTimePickers.
        // (None here at the moment.)
        //
        ///////////////////////////////////////////////////////////////////////////////////////////
        // This section creates date pickers and labels for demonstrating the language translations.
        
        addLocalizedPickerAndLabel(4, "Spanish:", "es"); 

        // This section creates an independent CalendarPanel.
        // This CalendarPanel includes a calendar selection listener and a border.
        DatePickerSettings settings = new DatePickerSettings();
        CalendarPanel calendarPanel = new CalendarPanel(settings);
        calendarPanel.setSelectedDate(LocalDate.now());
        
        calendarPanel.setBorder(new LineBorder(Color.lightGray));
        panel.independentCalendarPanel.add(calendarPanel, CC.xy(2, 2));

        // Display the frame.
        frame.pack();
        frame.validate();
        int maxWidth = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
        int maxHeight = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;
        frame.setSize(maxWidth / 4 * 3, maxHeight / 8 * 7);
        frame.setLocation(maxWidth / 8, maxHeight / 16);
        frame.setVisible(true);
    }

    /**
     * getConstraints, This returns a grid bag constraints object that can be used for placing a
     * component appropriately into a grid bag layout.
     */
    private static GridBagConstraints getConstraints(int gridx, int gridy, int gridwidth) {
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.WEST;
        gc.gridx = gridx;
        gc.gridy = gridy;
        gc.gridwidth = gridwidth;
        return gc;
    }

    /**
     * addLocalizedPickerAndLabel, This creates a date picker whose locale is set to the specified
     * language. This also sets the picker to today's date, creates a label for the date picker, and
     * adds the components to the language panel.
     */
    private static void addLocalizedPickerAndLabel(int rowMarker, String labelText,
        String languageCode) {
        // Create the localized date picker and label.
        Locale locale = new Locale(languageCode);
        DatePickerSettings settings = new DatePickerSettings(locale);
        // Set a minimum size for the localized date pickers, to improve the look of the demo.
        settings.setSizeTextFieldMinimumWidth(125);
        settings.setSizeTextFieldMinimumWidthDefaultOverride(true);
        DatePicker localizedDatePicker = new DatePicker(settings);
        localizedDatePicker.setDateToToday();
        panel.panel4.add(localizedDatePicker, getConstraints(1, (rowMarker * rowMultiplier), 1));
        panel.addLabel(panel.panel4, 1, (rowMarker * rowMultiplier), labelText);
    }

    
}