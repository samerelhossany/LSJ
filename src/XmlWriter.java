import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class XmlWriter {

    public static String m_templateHeader = "<?xml version=\"1.0\" encoding=\"utf-8\"?>  \n" +
            "<android.support.constraint.ConstraintLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"  \n" +
            "    xmlns:app=\"http://schemas.android.com/apk/res-auto\"  \n" +
            "    xmlns:tools=\"http://schemas.android.com/tools\"  \n" +
            "    android:layout_width=\"match_parent\"  \n" +
            "    android:layout_height=\"match_parent\"  \n" +
            "    tools:context=\"tcaiosc.ams.com.testing.MainActivity\">";

    public static String m_templateFooter = "</android.support.constraint.ConstraintLayout>";
    public static String f_swiftName = ReadFile.Swiftname;

    /** Soliman **/
    /* XmlFileWriter(xmlCode) is the function that gets called in the visitor class to start the xml conversion process
    * we pass to it the xmlCode, which is all of the UI converted components in the visitor class, incremented together */
    public static void xmlFileWrite(String xmlCode)
    {
        try {
            File swiftTojava = new File(f_swiftName);
            System.out.println(f_swiftName.substring(f_swiftName.indexOf('.')+1));
            swiftTojava = new File("xmlAndroid"+f_swiftName.substring(0,f_swiftName.indexOf('.'))+".xml");//creating a file for the xml conversion output.

            if(!swiftTojava.exists()) {//Checking if the file does not exist.
                swiftTojava.createNewFile();
            }

            PrintWriter files = new PrintWriter(swiftTojava);//specify the output file.
            files.println(m_templateHeader);//Adding the layout header.
            files.println(xmlCode);//Adding the incremented code from the visitor.
            files.println(m_templateFooter);//Adding the layout footer.
            files.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /* Alert XML conversion function */
    public static String alertConverter(String id, String text)
    {
        String button_template = "<Button  \n" +
                "        android:layout_width=\"wrap_content\"  \n" +
                "        android:layout_height=\"wrap_content\"  \n" +
                "        android:id=\"@+id/"+id+"\"  \n" +
                "        android:text=\""+ text +"\"  \n" +
                "        app:layout_constraintBottom_toBottomOf=\"parent\"  \n" +
                "        app:layout_constraintLeft_toLeftOf=\"parent\"  \n" +
                "        app:layout_constraintRight_toRightOf=\"parent\"  \n" +
                "        app:layout_constraintTop_toTopOf=\"parent\" />\n";
        return button_template;
    }

    /* Image XML conversion function */
    public static String imageConverter(String id, String description)
    {
        String image_template = "<ImageView\n" +
                "         android:layout_width=\"wrap_content\"\n" +
                "         android:layout_height=\"wrap_content\"\n" +
                "         android:src=\"@drawable/"+id+"\"\n" +
                "         android:contentDescription=\"@string/"+description+"\"/>\n";
        return image_template;
    }

    /* TextField XML conversion function */
    public static String textFieldConverter(String id, String text)
    {
        String EditText_template = "<EditText\n" +
                "    android:id=\"@+id/"+id+"\"\n" +
                "    android:layout_width=\"fill_parent\"\n" +
                "    android:layout_height=\"wrap_content\"\n" +
                "    android:text=\""+text+"\"/>\n";
        return EditText_template;
    }

    /* TextEditor XML conversion function */
    public static String TextEditorConverter(String id, String text)
    {
        String TextView_template = "<TextView\n" +
                "        android:id=\"@+id/"+id+"\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        android:layout_width=\"wrap_content\"\n" +
                "        android:text=\"@string/"+text+"\" />\n";
        return TextView_template;
    }

    /* Button XML conversion function */
    public static String ButtonConverter(String id, String text)
    {
        String button_template = "<Button  \n" +
                "        android:layout_width=\"wrap_content\"  \n" +
                "        android:layout_height=\"wrap_content\"  \n" +
                "        android:id=\"@+id/"+id+"\"  \n" +
                "        android:text="+ text +"  \n" +
                "        app:layout_constraintBottom_toBottomOf=\"parent\"  \n" +
                "        app:layout_constraintLeft_toLeftOf=\"parent\"  \n" +
                "        app:layout_constraintRight_toRightOf=\"parent\"  \n" +
                "        app:layout_constraintTop_toTopOf=\"parent\" />\n";
        return button_template;
    }

    /* Switch XML conversion function */
    public static String SwitchConverter(String id,String text){
        String switch_template = "<Switch\n" +
                "android:id=\"@+id/"+id+"\"\n" +
                "android:layout_width=\"wrap_content\"\n" +
                "android:layout_height=\"wrap_content\"\n" +
                "android:layout_centerHorizontal=\"true\"\n" +
                "android:text="+text+" />";
        return switch_template;
    }
    public static String URLConverter(String id, String text)
    {
        String button_template = "<Button  \n" +
                "        android:layout_width=\"wrap_content\"  \n" +
                "        android:layout_height=\"wrap_content\"  \n" +
                "        android:id=\"@+id/"+id+"\"  \n" +
                "        android:text="+ text +"  \n" +
                "        app:layout_constraintBottom_toBottomOf=\"parent\"  \n" +
                "        app:layout_constraintLeft_toLeftOf=\"parent\"  \n" +
                "        app:layout_constraintRight_toRightOf=\"parent\"  \n" +
                "        app:layout_constraintTop_toTopOf=\"parent\" />\n";
        return button_template;
    }
    public static String ProgressBarConverter(String PBID,String TVID,String text,String Max,String Progress){
        String ProgressBar_template = "<RelativeLayout\n" +
                "        android:layout_width=\"match_parent\"\n" +
                "        android:layout_height=\"match_parent\">\n" +
                "        <ProgressBar\n" +
                "                android:id=\"@+id/"+PBID+"\"\n" +
                "                style=\"@android:style/Widget.ProgressBar.Horizontal\"\n" +
                "                android:progressDrawable=\"@drawable/customprogressbar\"\n" +
                "                android:layout_width=\"match_parent\"\n" +
                "                android:layout_height=\"match_parent\"\n" +
                "                android:progress=\""+Progress+"\"\n" +
                "                android:max=\""+Max+"\"/>\n" +
                "\n" +
                "        <TextView\n" +
                "                android:id=\"@+id/"+TVID+"\"\n" +
                "                android:layout_width=\"wrap_content\"\n" +
                "                android:layout_height=\"wrap_content\"\n" +
                "                android:layout_alignParentLeft=\"true\"\n" +
                "                android:layout_alignParentRight=\"true\"\n" +
                "                android:layout_centerVertical=\"true\"\n" +
                "                android:gravity=\"center\"\n" +
                "                android:text=\"@string/"+text+"\" />\n" +
                "</RelativeLayout>\n";
        return ProgressBar_template;
    }
    public static String SecureFieldConverter(String id,String text){
        String SecureField_template ="<EditText\n" +
                "        android:id=\"@+id/"+id+"\"\n" +
                "        android:layout_width=\"match_parent\"\n" +
                "        android:layout_height=\"wrap_content\"\n" +
                "        android:text=\""+text+"\"/>\n"+
                "        android:inputType=\"textPassword\" >\n" +
                "\n" +
                "        <requestFocus />\n" +
                "    </EditText>\n";
        return SecureField_template;
    }
}
