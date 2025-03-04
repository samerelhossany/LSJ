import com.google.gson.stream.JsonToken;
import generatedantlr.Swift3BaseVisitor;
import generatedantlr.Swift3Parser;
import java.util.ArrayList;

import javax.xml.crypto.Data;
import java.sql.SQLOutput;
import java.util.*;
import java.util.List;

public class SwiftToJavaVisitor extends Swift3BaseVisitor<String> {
    public String swiftType;
    public String swift_identifier;
    public String Alert_message = "";
    public String Literal_expression;
    public String class_name_dataType;
    public ArrayList<String>  parameters_closure_dataTypes = new ArrayList<String>();
    public ArrayList<String>  parameters_closure_variables = new ArrayList<String>();
    public ArrayList<String> dic_key_array = new ArrayList<String>();
    public ArrayList<String> dic_value_array = new ArrayList<String>();

    public ArrayList<String> dic_key_value_dataTypes_array = new ArrayList<String>();
    public ArrayList<String> key_value_for_tuple_array = new ArrayList<String>();
    public boolean closure_return_flag=false;
    public HashMap<String, String> swiftTypeIDentifier = new HashMap<String, String>();
    public HashMap<String,String>  swiftStrings = new HashMap<String,String>();
    public String array_type;
    public String for_iterator;
    public  String ourclass;
    public String Java_import="";
    public String java_readline = "";
    public int for_flag=0;
    public boolean closure_statement_flag = false;
    public boolean closure_before_return_exp_flag = false;
    public boolean array_dic_brackets_flag=false;
    public boolean closure_var_names_flag = false;
    public boolean dic_import_flag=false;
    public boolean key_value_for_tuple_flag= false;
    public  int class_flag =0;
    public  int print_counter = 0;
    public int Alert_counter =0;
    public int TextEdit_counter=0;
    public int TextField_counter=0;
    public int Image_counter=0;
    public  boolean insert_flag =false;
    public  boolean inherit_flag =false;
    public  boolean text_flag =false;
    public boolean toastflag=false;
    public boolean exclamation_tag=false;
    public boolean Intentflag=false;
    public boolean extrabrace_flag=false;
    public boolean binary_flag=false;
    public boolean Old_URL_flag =false;
    public boolean Image_flag=false;
    public boolean Alert_flag=false;
    public boolean TextEdit_flag=false;
    public boolean TextField_flag=false;
    //modification by samer in the statement " userinput = readLine()
    public boolean exp_readline_flag =false;
    public boolean scanner_object_flag = true;
    public String literal_annotation="";
    public List <String> classlist = new ArrayList<String>();
    public static boolean variable_declaration_flag = false;
    public String caller;
    public String literal_type= "";
    public static boolean print_statement_flag = false;
    /** XML **/
    public static String XMLCode = " ";
    XmlWriter xw = new XmlWriter();

    /** Alert **/
    public static String XMLAlertIdentifier;
    public static String XMLAlertText;
    public static boolean XMLAlert_isReady;
    public static HashMap<String,String> AlertAttributes = new HashMap<>();

    /** Image **/
    public static String XMLImageIdentifier;
    public static String XMLImageDescription;
    public static boolean XMLImage_isReady;

    /** TextField **/
    public static String XMLTextFieldIdentifier;
    public static String XMLTextFieldText;
    public static boolean XMLTextField_isReady;

    /** TextEditor **/
    public static String XMLTextEditorIdentifier;
    public static String XMLTextEditorText;
    public static boolean XMLTextEditor_isReady;

    /**** Button ****/
    /** Java **/
    public static boolean Button_flag = false;
    public static int Button_counter = 0;
    public static String Button_Action ="";
    public static boolean Button_Action_Inprogress_wait_flag = false;
    public static String HardCodedLiteral_Expression ;
    public static boolean Button_HCLE_flag = false;
    public static int Button_HCLE = 0;
    public static String ButtonText;
    /** XML **/
    public static String XMLButtonIdentifier;
    public static String XMLButtonText;
    public static boolean XMLButton_isReady = false;

    /** Toggle **/
    /** Java **/
    public static boolean Switch_flag = false;
    public static int Switch_counter = 0;
    public static String Switch_Action;
    public static boolean Switch_Action_Inprogress_flag = false;
    public static boolean Switch_HCLE_flag = false;
    public static int Switch_HCLE = 0;
    public static String SwitchText;
    /** XML **/
    public static String XMLSwitchIdentifier;
    public static String XMLSwitchText;
    public static boolean XMLSwitch_isReady;

    /** URL **/
    /** Java **/
    public static boolean URL_flag = false;
    public static int URL_counter = 0;
    public static String URL_link ="";
    public static boolean URL_Text_flag = false;
    public static boolean URL_Link_flag = false;
    public static boolean URL_Link_Inprogress_wait_flag = false;
    public static boolean URL_HCLE_flag = false;
    public static int URL_HCLE = 0;
    public static String URLText = "";
    /** XML **/
    public static String XMLURLIdentifier;
    public static String XMLURLText;
    public static boolean XMLURL_irReady = false;

    /**** Button_URL ****/
    /** Java **/
    public static int Button_URL_counter = 0;
    public static String Button_URL_Link ="";
    public static boolean Button_URL_HCLE_flag = false;
    public static int Button_URL_HCLE = 0;
    public static String Button_URLText;
    public static boolean Button_URL_flag = false;
    public static boolean Button_URL_isReady = false;
    /** XML **/
    public static String XMLButton_URLIdentifier;
    public static String XMLButton_URLText;
    public static boolean XMLButton_URL_isReady = false;
    /**** ProgressBar ****/
    /** Java **/
    public static boolean ProgressBar_flag = false;
    public static int ProgressBar_counter = 0;
    public static String ProgressBar_Action ="";
    public static boolean ProgressBar_Action_Inprogress_wait_flag = false;
    public static boolean ProgressBar_HCLE_flag = false;
    public static int ProgressBar_HCLE = 0;
    public static String ProgressBarText;
    public static String ProgressBar_Max = "";
    public static String ProgressBar_Progress = "";
    /** XML **/
    public static String XMLProgressBarIdentifier;
    public static String XMLProgressBarMax;
    public static String XMLProgressBarProgress;
    public static String XMLPBTextViewIdentifier;
    public static String XMLPBTextViewText;
    public static boolean XMLProgressBar_isReady = false;
    /**** SecureField ****/
    /** Java **/
    public static boolean SecureField_flag = false;
    public static int SecureField_counter = 0;
    /** XML **/
    public static String XMLSecureFieldIdentifier;
    public static String XMLSecureFieldText;
    public static boolean XMLSecureField_isReady;




    public static int cc=0;

    /*****************************/
    /** Temporary Variables **/
    /*This hashmap is used to store the boolean expressions in the source code to match the boolean attribute in the switch(Toggle) component*/
    public static HashMap<String,String> BooleanHM = new HashMap<>();
    /** Soliman **/
    /* This ArrayList contains the flags of all quoted statements that shouldn't be deleted, to consider them while converted the literal expressions*/
    public static ArrayList<Boolean> quoted_statements = new ArrayList<Boolean>();
    public static boolean FunctionCall_flag = false;
    public static boolean openURL_flag = false;


    public static String TextRegex = "[\"\'][_-a-zA-Z0-9]*[\"\']";

    /*public String getToDoCommentedJavaCode(Swift3Parser.Prefix_expressionContext ctx){
        // didn't use getText directly to get the original text with spacing.
        int a = ctx.start.getStartIndex();
        int b = ctx.stop.getStopIndex();
        Interval interval = new Interval(a,b);
        String code= ctx.start.getInputStream().getText(interval);
        return   code;
    }*/
    @Override
    public String visitTop_level(Swift3Parser.Top_levelContext ctx) {
        String Java_top="";
        Java_top+=visitStatements(ctx.statements());
        if (Java_top.contains("Intent"))
        {
            Java_import+="import android.content.Intent; \n";
        }
        if(Java_top.contains("Button"))
        {
            Java_import+="import android.widget.Button;\n";
        }
        if (Java_top.contains("Math"))
        {
            Java_import+="import java.lang.Math;\n";
        }
        if(Java_top.contains("String"))
        {
            Java_import+="import java.lang.String;\n";
        }
        if(Java_top.contains("TextView"))
        {
            Java_import+="import android.widget.TextView;\n";
            Java_import+="import android.widget.EditText;\n";
        }
        if(Java_top.contains("ListView"))
        {
            Java_import+="import android.widget.ListView;\n";
        }
        if(Java_top.contains("AppCompatActivity"))
        {
            Java_import+="import androidx.appcompat.app.AppCompatActivity;\n";
        }
        if(Java_top.contains("ArrayList")) {
            Java_import += "import java.util.ArrayList;\n";
            Java_import += "import java.util.List;\n";

        }
        // modification to add a scanner object by: samer
        if(ctx.getText().contains("readLine()"))
        {
            Java_import+="import java.util.Scanner;\n";
        }
        //----------------------------------------------------------------------------------
        if (Java_top.contains("Bundle"))
        {
            Java_import+="import android.os.Bundle;\n";
        }
        if(Java_top.contains("AlertDialog"))
        {
            Java_import +="import android.app.AlertDialog;\n";
        }
        if (Java_top.contains("Toast.makeText") ){
            Java_import+="import android.widget.Toast;\n";
        }
        if (Java_top.contains("startActivity"))
        {
            Java_import+="import android.app.Activity; \n";
        }
        if(Java_top.contains("OnClickListener"))
        {
            Java_import+="import android.view.View.OnClickListener;\n";
        }
        if(Java_top.contains("View"))
        {
            Java_import+="import android.view.View;\n";
        }
        if(Java_top.contains("Uri"))
        {
            Java_import+="import android.net.Uri; \n";
        }
        if(Java_top.contains("Vibrator"))
        {
            Java_import+="import android.os.Vibrator;\n";
        }
        if (Java_top.contains("VibrationEffect"))
        {
            Java_import+="import android.os.VibrationEffect;\n";
        }if(Java_top.contains("min")||Java_top.contains("max")||Java_top.contains("reversed"))
        {
            Java_import+="import java.util.Collections;\n";
        }


        if (extrabrace_flag)
        {
            extrabrace_flag=false;
            Java_top+="\n}";
        }
        //the line that print the full top level statement
       // System.out.println(ctx.getText()+"$");
        if(dic_import_flag) {
            //add the flag of hashmap and map here
            Java_import+="import java.util.Map;\n";
            Java_import+="import java.util.HashMap;\n";
            dic_import_flag=false;
        }
        return Java_import+Java_top;
    }

    @Override
    public String visitStatements(Swift3Parser.StatementsContext ctx) {
        //try {
        quoted_statements.add(print_statement_flag);
        quoted_statements.add(variable_declaration_flag);
            String Java_statements = "";
        //System.out.println(ctx.getText());

            Java_statements += visitStatements_impl(ctx.statements_impl());

            return Java_statements;
        }/*catch(Exception e){

            return"TCIOSACERROR Statements "+visitStatement(ctx.statements_impl().statement());
        }
    }*/


    @Override
   public String visitStatements_impl(Swift3Parser.Statements_implContext ctx) {
        //try {
        String Java_stmt_impl="";


        // modification to add a scanner object by: samer
        if(ctx.getText().contains("readLine()") && scanner_object_flag)
        {
            Java_stmt_impl+="Scanner scanner = new Scanner(System.in);\n";
            scanner_object_flag= false;//flag to prevent the prevention of printing this line
        }
        //----------------------------------------------------------------------------------

        Java_stmt_impl+=visitStatement(ctx.statement())+"\n";
        //System.out.println(ctx.statements_impl().statement().expression().getText() + " "+ ctx.statement().declaration().variable_declaration().pattern_initializer_list().getText() + " " + ctx.statements_impl().getText());

        if(ctx.statements_impl()!=null)
        {


                Java_stmt_impl += visitStatements_impl(ctx.statements_impl());


        }

        return Java_stmt_impl;
//        }catch(Exception e){
//            String Java_stmt_impl="";
//            Java_stmt_impl = visitStatement(ctx.statement());
//            return"TCIOSACERROR "+Java_stmt_impl;
//        }
    }



    @Override
    public String visitStatement(Swift3Parser.StatementContext ctx) {
        //try {
            String J_code = "";
            try {
                if (ctx.branch_statement() != null) {

                    J_code += visitBranch_statement(ctx.branch_statement());
                } else if (ctx.declaration() != null) {

                    J_code += visitDeclaration(ctx.declaration());

                } else if (ctx.loop_statement() != null) {

                    J_code += visitLoop_statement(ctx.loop_statement());
                } else if (ctx.expression() != null) {

                    if (ctx.getText().contains("override")) {

                        J_code += "@Override";
                    } else {

                        J_code += visitExpression(ctx.expression());
                        J_code += ";";

                    }

                } else if (ctx.control_transfer_statement() != null) {

                    J_code += visitControl_transfer_statement(ctx.control_transfer_statement());

                } else if (ctx.labeled_statement() != null) {
                    J_code += ctx.labeled_statement().getText();
                } else {
                    return J_code;
                }
                /** Soliman **/

                /* Same process for all components, until now. */
                if (XMLAlert_isReady) {//Checking if the Alert component is ready for the conversion.
                    XMLCode += XmlWriter.alertConverter(XMLAlertIdentifier, XMLAlertText);//Passing the collected parameters.
                    XMLAlert_isReady = false;//Indicating that the Alert XML conversion process is terminated.
                }
                if (XMLImage_isReady) {
                    XMLCode += XmlWriter.imageConverter(XMLImageIdentifier, XMLImageDescription);
                    XMLImage_isReady = false;
                }
                if (XMLTextField_isReady) {
                    XMLCode += XmlWriter.textFieldConverter(XMLTextFieldIdentifier, XMLTextFieldText);
                    XMLTextField_isReady = false;
                }
                if (XMLTextEditor_isReady) {
                    XMLCode += XmlWriter.TextEditorConverter(XMLTextEditorIdentifier, XMLTextEditorText);
                    XMLTextEditor_isReady = false;
                }
                if (XMLButton_isReady) {
                    XMLCode += XmlWriter.ButtonConverter(XMLButtonIdentifier, XMLButtonText);
                    XMLButton_isReady = false;
                }
                if (XMLSwitch_isReady) {
                    XMLCode += XmlWriter.SwitchConverter(XMLSwitchIdentifier, XMLSwitchText);
                    XMLSwitch_isReady = false;
                }
                if (XMLURL_irReady) {
                    XMLCode += XmlWriter.URLConverter(XMLURLIdentifier, XMLURLText);
                    XMLURL_irReady = false;
                }
                if (XMLButton_URL_isReady) {
                    XMLCode += XmlWriter.ButtonConverter(XMLButton_URLIdentifier, XMLButton_URLText);
                    XMLButton_URL_isReady = false;
                }
                if (XMLProgressBar_isReady) {
                    XMLCode += XmlWriter.ProgressBarConverter(XMLProgressBarIdentifier, XMLPBTextViewIdentifier, XMLPBTextViewText, XMLProgressBarMax, XMLProgressBarProgress);
                    XMLProgressBar_isReady = false;
                }
                if (XMLSecureField_isReady) {
                    XMLCode += XmlWriter.SecureFieldConverter(XMLSecureFieldIdentifier, XMLSecureFieldText);
                    XMLSecureField_isReady = false;
                }
                //XmlWriter.xmlFileWrite(XMLCode);//Calling the xmlFileWriter Function and passing the incremented UI components code to add the to the XML layout and start the writing process.
            }catch(Exception e) {
                J_code+="TCIOSACERROR\n" ;
            }
        return J_code;
//        }catch(Exception e){
//            String J_code = "";
//            J_code = visitExpression(ctx.expression());
//            return "TCIOSACERROR "+J_code;
//        }
    }



    @Override
    public String visitControl_transfer_statement(Swift3Parser.Control_transfer_statementContext ctx) {
        String Java_control="";

        Java_control+=visitReturn_statement(ctx.return_statement());
        return Java_control;
    }

    @Override
    public String visitReturn_statement(Swift3Parser.Return_statementContext ctx) {
        String Java_return="return ";

        if(closure_return_flag){//by samer: flag to prevent the return keyword to be written in the closure statement)
            Java_return="";

        }

        if(ctx.expression()!=null)
        {
            Java_return+=visitExpression(ctx.expression());

        }


        return Java_return+";";
    }

    @Override
    public String visitLoop_statement(Swift3Parser.Loop_statementContext ctx) {

        String Java_loop="";
        if (ctx.while_statement() != null)
        {
            Java_loop += visitWhile_statement(ctx.while_statement());

        }
        else if (ctx.repeat_while_statement() != null)
        {
            Java_loop += visitRepeat_while_statement(ctx.repeat_while_statement());
        }
        else if(ctx.for_in_statement()!= null)
        {
            Java_loop+=visitFor_in_statement(ctx.for_in_statement());
        }
        return Java_loop;
    }

    @Override
    public String visitFor_in_statement(Swift3Parser.For_in_statementContext ctx) {

        try {

            String Java_for = "";
            Java_for += "for (";
            if(ctx.pattern().tuple_pattern() != null)
            {
                key_value_for_tuple_flag= true;
                for(int i=0;i<2;i++)//by samer: this loop will take the values of the key and the value and store it inside an array.
                    key_value_for_tuple_array.add(ctx.pattern().tuple_pattern().tuple_pattern_element_list().tuple_pattern_element(i).getText());

            }
           // if(ctx.pattern().type_annotation() == null ||( ctx.getText().contains("...")||ctx.getText().contains("..<")))
                visitExpression(ctx.expression());

            if (ctx.pattern().tuple_pattern() == null) {


               if(literal_type == "String")
                   literal_type = "char";

                Java_for+= literal_type+" ";
            }
                //ctx.expression().prefix_expression().postfix_expression().getText()  --> 1
                // ctx.expression().binary_expressions().binary_expression(0).prefix_expression().getText() --> 5
            if (ctx.pattern().tuple_pattern() != null) {
                Java_for+="Map.Entry<";
                Java_for+=dic_key_value_dataTypes_array.get(0)+","+dic_key_value_dataTypes_array.get(1);
                Java_for+=">";
                Java_for+=" entry";

            }
            if (ctx.pattern().tuple_pattern() == null) {


                for_iterator = visitPattern(ctx.pattern());

            }
            else
                for_iterator = "";

            if(ctx.getChild(2).getText().contains("in"))
                Java_for += for_iterator+" : ";
            else Java_for += for_iterator+" = ";

            if (ctx.pattern().tuple_pattern() == null) {
                Java_for += visitExpression(ctx.expression()) + ")";
            }
            else
                Java_for += visitExpression(ctx.expression())+".entrySet())";
            Java_for += "{\n";
            if(ctx.pattern().tuple_pattern() != null){ // remove the error that will generated when where clause is null
              if(ctx.where_clause() == null) {
                      if (ctx.where_clause().getText() != null) {
                          Java_for += "if( ";

                          Java_for += ctx.where_clause().where_expression().getText();
                          Java_for += ")\n";
                          Java_for += "{\n";


                          Java_for += visitCode_block(ctx.code_block());


                          Java_for += "}\n";
                      }
              }
            }
            else
                Java_for += visitCode_block(ctx.code_block());

            Java_for += "\n}";
            return Java_for;
        }catch (Exception e){
            return "TCIOSACERROR "+visitExpression(ctx.expression());
        }
    }

    @Override
    public String visitRepeat_while_statement(Swift3Parser.Repeat_while_statementContext ctx) {

        String java_repeat="";
        java_repeat += "do ";
        java_repeat += "{\n";
        java_repeat+=visitCode_block(ctx.code_block());
        java_repeat+="\n}";
        java_repeat += "while ";
        java_repeat += "( "+ ctx.expression().getText()+" );";
        return java_repeat;
    }

    @Override
    public String visitCode_block(Swift3Parser.Code_blockContext ctx) {
        String java_block = "";

        try {

            if (ctx.statements() != null) {

                java_block += visitStatements(ctx.statements());


            }
            return java_block;
        }catch (Exception e){
            java_block+="TCIOSACERROR ";
            java_block+=ctx.getText();
            return java_block;
        }
    }

    @Override
    public String visitWhile_statement(Swift3Parser.While_statementContext ctx) {

        String Java_while="";
        Java_while+="while";
        Java_while+=" ("+ctx.condition_list().condition(0).expression().getText()+")";
        Java_while+=" {\n";
        Java_while+=visitCode_block(ctx.code_block());
        Java_while+="\n}";
        return Java_while;
    }

    @Override
    public String visitDeclaration(Swift3Parser.DeclarationContext ctx) {
        //try {


        String Java_declaration="";
        if(ctx.import_declaration() != null)
        {
            Java_declaration += "";

        }
        if(ctx.variable_declaration()!=null){
            variable_declaration_flag = true;

            Java_declaration+=visitVariable_declaration(ctx.variable_declaration());

            variable_declaration_flag = false;
        }
        else if(ctx.constant_declaration()!=null){
            Java_declaration+=visitConstant_declaration(ctx.constant_declaration());
        }
        else if(ctx.class_declaration()!=null)
        {

            Java_declaration+=visitClass_declaration(ctx.class_declaration());

        }
        else if (ctx.struct_declaration()!= null)
        {
            Java_declaration+=visitStruct_declaration(ctx.struct_declaration());
        }
        else if(ctx.function_declaration()!=null)
        {

            Java_declaration+=visitFunction_declaration(ctx.function_declaration());

        }
        else if(ctx.initializer_declaration()!=null)
        {
            Java_declaration+=visitInitializer_declaration(ctx.initializer_declaration());
        }
        else if(ctx.struct_declaration()!= null)
        {
            Java_declaration+=visitStruct_declaration(ctx.struct_declaration());
        }

        return Java_declaration;
        }/*catch(Exception e){
            return "TCIOSACERROR declaration";
        }
    }*/


    @Override
    public String visitStruct_declaration(Swift3Parser.Struct_declarationContext ctx) {
        String Java_struct="";
        String Java_acesslevel= "";

        if(ctx.access_level_modifier()!=null) {
            Java_acesslevel=DataBaseResources.getJavaDataType(ctx.access_level_modifier().getText());
            Java_struct += Java_acesslevel;

        }
        Java_struct+=" class ";
        Java_struct+=ctx.struct_name().getText()+" ";
        ourclass=ctx.struct_name().getText();
        classlist.add(ctx.struct_name().getText());

        if(ctx.type_inheritance_clause()!= null) {

            String Inherit = ctx.type_inheritance_clause().type_inheritance_list().type_identifier().type_name().getText();
            String Java_Inherit = built_in_methods.getJavamethod(Inherit);
            if (Inherit != null) {
                inherit_flag = true;
                if (Java_Inherit != null)
                    Java_struct += "extends " + Java_Inherit;
                else
                    Java_struct += "extends " + Inherit;
            }
        }
        Java_struct+="{\n"+ visitStruct_body(ctx.struct_body())+"\n}";

        return Java_struct;
    }

    @Override
    public String visitStruct_body(Swift3Parser.Struct_bodyContext ctx) {
        String Struct_body = "";
        for (int i = 0; i < ctx.struct_member().size(); i++) {
            Struct_body += visitStruct_member(ctx.struct_member(i));
            Struct_body += "\n";
            swiftStrings.put(swift_identifier,Literal_expression);
        }
        return Struct_body;
    }

    @Override
    public String visitStruct_member(Swift3Parser.Struct_memberContext ctx) {
        String Struct_member = "";
        Struct_member += visitDeclaration(ctx.declaration());

        return Struct_member;
        }

    @Override
    public String visitInitializer_declaration(Swift3Parser.Initializer_declarationContext ctx) {
        String Java_init_declaration="";
        if(ctx.initializer_head().getText().contains("init"))
        {
            Java_init_declaration+="public ";
            Java_init_declaration+=ourclass+"(";
        }
        Java_init_declaration+=visitParameter_list(ctx.parameter_clause().parameter_list())+")";
        Java_init_declaration+="\n {\n";
        Java_init_declaration+=visitCode_block(ctx.initializer_body().code_block());
        Java_init_declaration+="\n}";
        return Java_init_declaration;
    }



    @Override
    public String visitParameter_list(Swift3Parser.Parameter_listContext ctx) {
        String Java_parameter="";
        for(int i =0;i<ctx.parameter().size();i++)
        {

            Java_parameter += visitType_annotation(ctx.parameter(i).type_annotation()) + " ";



            Java_parameter += ctx.parameter(i).local_parameter_name().getText() ;

            if(i!=ctx.parameter().size()-1)
                Java_parameter+=",";
        }
        return Java_parameter;
    }

    @Override
    public String visitFunction_declaration(Swift3Parser.Function_declarationContext ctx) {
        String Java_function="";
        String javatype="";

        if(ctx.function_head().declaration_modifiers() != null) {

            if (ctx.function_head().declaration_modifiers().declaration_modifier(0).getText().contains("override")) {

                Java_function += "@Override  \n";
            }
            if(ctx.function_head().declaration_modifiers().declaration_modifier(0).access_level_modifier()!= null) {

                String Java_access = ctx.function_head().declaration_modifiers().declaration_modifier(0).access_level_modifier().getText();
                //System.out.println(Java_access);
                if(DataBaseResources.getJavaDataType(Java_access)!= null) {
                    Java_function += DataBaseResources.getJavaDataType(Java_access) + " ";
                }
                else
                    Java_function+= Java_access + " ";


            }
        }
        if(ctx.function_head().declaration_modifiers() == null) {
            Java_function+="public";
            Java_function+=" ";

        }

        if (ctx.function_head().getText().contains("IBAction"))
        {
            Java_function+="Button "+ctx.function_name().getText()+";\n";
            Java_function+=ctx.function_name().getText()+" = (Button) findViewById(R.id."+ctx.function_name().getText()+");\n";
            Java_function+=ctx.function_name().getText()+".setOnClickListener(new View.OnClickListener() {  \n";
            Java_function+="@Override  \n" +
                    "            public void onClick(View view) ";
            Java_function += "\n{\n";
            Java_function += visitCode_block(ctx.function_body().code_block());
            Java_function += "\n} \n });";

            return Java_function;
        }
        else if(ctx.function_signature().function_result()==null)
        {
            javatype+="void";
        }

        else {


            javatype += DataBaseResources.getJavaDataType(ctx.function_signature().function_result().type().getChild(0).getText());

        }
        Java_function+=javatype+" ";
        if(ctx.function_name().getText().contains("viewDidLoad"))
        {
            Java_function+="onCreate(Bundle savedInstanceState) {\n";
            extrabrace_flag=true;
            Java_function += visitCode_block(ctx.function_body().code_block());
            return Java_function;

        }
        else {
            Java_function += ctx.function_name().getText() + "(";
            Java_function += visitFunction_signature(ctx.function_signature()) + " ";

        }

        Java_function += "\n{\n";
        Java_function += visitCode_block(ctx.function_body().code_block());
        Java_function += "\n}";
        return Java_function;
    }

    @Override
    public String visitFunction_signature(Swift3Parser.Function_signatureContext ctx) {
        String Java_sig="";
        if(ctx.parameter_clause().parameter_list()!=null) {
            Java_sig +=visitParameter_list(ctx.parameter_clause().parameter_list())+")";

        }
        else{

            Java_sig+=")";

        }
        return  Java_sig;
    }

    @Override
    public String  visitConstant_declaration(Swift3Parser.Constant_declarationContext ctx) {
        String Java_constant="";


        if(ctx.getText().contains("let")) {

            visitPattern_initializer_list(ctx.pattern_initializer_list());

          if(class_name_dataType != null) {

             // System.out.println("\033[31;1m"+ctx.getText().indexOf("=") +"\033[0m");
              if(ctx.getText().indexOf("=") != -1)
                 if (!dic_import_flag && !class_name_dataType.equals(ctx.getText().substring(ctx.getText().indexOf("=") + 1, ctx.getText().indexOf("(")).trim()))

                    Java_constant += "final ";
          }
          else{

              if (!dic_import_flag)

                  Java_constant += "final ";

          }
        }


         if(ctx.getText().contains("let") && ctx.getText().contains(":") && ctx.getText().contains("->" ))//modification by samer: first statement in closure statement
         {
             Java_constant += "interface Operation {\n";
             closure_statement_flag = true;
             closure_return_flag=true;
             closure_before_return_exp_flag=true;
         }

        Java_constant+=visitPattern_initializer_list(ctx.pattern_initializer_list()); //removed adding the semicolon from here AY


        return Java_constant+";";
    }

    @Override
    public String visitClass_declaration(Swift3Parser.Class_declarationContext ctx) {
        String Java_class="";
        String Java_acesslevel= "";
        class_name_dataType= ctx.class_name().getText();

        if(ctx.access_level_modifier(0)!=null) {
            Java_acesslevel=DataBaseResources.getJavaDataType(ctx.access_level_modifier(0).getText());
            Java_class += Java_acesslevel;

        }
        Java_class+=" class ";

        Java_class+=ctx.class_name().getText()+" ";
        ourclass=ctx.class_name().getText();
        classlist.add(ctx.class_name().getText());


        if(ctx.type_inheritance_clause()!= null) {
            String Inherit = ctx.type_inheritance_clause().type_inheritance_list().type_identifier().type_name().getText();
            String Java_Inherit = built_in_methods.getJavamethod(Inherit);
            if (Inherit != null) {
                inherit_flag = true;
                if (Java_Inherit != null)
                    Java_class += "extends " + Java_Inherit;
                else
                    Java_class += "extends " + Inherit;

            }
        }

        Java_class+="{\n"+ visitClass_body(ctx.class_body())+"\n}";

        return Java_class;
    }

    @Override
    public String visitClass_body(Swift3Parser.Class_bodyContext ctx) {
        String java_class_body="";
        for (int i = 0 ; i < ctx.class_member().size(); i++ )
        {

            java_class_body += visitDeclaration(ctx.class_member(i).declaration())+"\n";

        }
        return java_class_body;
    }

    @Override
    public String visitBranch_statement(Swift3Parser.Branch_statementContext ctx) {
        String java_branch ="";
        if (ctx.if_statement()!=null)
        {
            java_branch += visitIf_statement(ctx.if_statement());
        }
        else if (ctx.switch_statement()!=null) {
            java_branch += visitSwitch_statement(ctx.switch_statement());
        }
        else if(ctx.guard_statement()!=null)
        {
            java_branch+= visitGuard_statement(ctx.guard_statement());
        }


        return java_branch;
    }
    @Override
    public String visitGuard_statement(Swift3Parser.Guard_statementContext ctx){
        String java_guard="";
        if (ctx.getText().contains("URL_old")&&ctx.getText().contains("tel://"))
        {
            String url=ctx.condition_list().condition(0).optional_binding_condition().pattern().getText();
            java_guard+="Intent "+url+" = new Intent(Intent.ACTION_CALL);\n";
            java_guard+=url+".setData(Uri.parse(";
            Swift3Parser.Function_call_expressionContext fctc=  (Swift3Parser.Function_call_expressionContext) ctx.condition_list().condition(0).optional_binding_condition().initializer().expression().prefix_expression().postfix_expression();
            java_guard+= fctc.function_call_argument_clause().function_call_argument_list().function_call_argument(0).expression().getText();
            java_guard+="); \n";
        }
        if (ctx.getText().contains("URL_old")&&ctx.getText().contains("https://"))
        {
            String url=ctx.condition_list().condition(0).optional_binding_condition().pattern().getText();
            java_guard+="Intent "+url+" = new Intent(Intent.ACTION_VIEW);\n";
            java_guard+=url+".setData(Uri.parse(";
            Swift3Parser.Function_call_expressionContext fctc=  (Swift3Parser.Function_call_expressionContext) ctx.condition_list().condition(0).optional_binding_condition().initializer().expression().prefix_expression().postfix_expression();
            java_guard+= fctc.function_call_argument_clause().function_call_argument_list().function_call_argument(0).expression().getText();
            java_guard+="); \n";
        }
        return java_guard;
    }

    @Override
    public String visitIf_statement(Swift3Parser.If_statementContext ctx) {
        //try {
            String java_if = "";
            if (ctx.getText().contains("URL_old") && ctx.getText().contains("tel://")) {
                String url = ctx.condition_list().condition(0).optional_binding_condition().pattern().getText();
                java_if += "Intent " + url + " = new Intent(Intent.ACTION_CALL);\n";
                java_if += url + ".setData(Uri.parse(";
                Swift3Parser.Function_call_expressionContext fctc = (Swift3Parser.Function_call_expressionContext) ctx.condition_list().condition(0).optional_binding_condition().initializer().expression().prefix_expression().postfix_expression();
                java_if += fctc.function_call_argument_clause().function_call_argument_list().function_call_argument(0).expression().getText();
                java_if += "); \n";
                java_if += visitCode_block(ctx.code_block());
                return java_if;
            }
            if (ctx.getText().contains("URL_old") && ctx.getText().contains("https://")) {
                String url = ctx.condition_list().condition(0).optional_binding_condition().pattern().getText();
                java_if += "Intent " + url + " = new Intent(Intent.ACTION_VIEW);\n";
                java_if += url + ".setData(Uri.parse(";
                Swift3Parser.Function_call_expressionContext fctc = (Swift3Parser.Function_call_expressionContext) ctx.condition_list().condition(0).optional_binding_condition().initializer().expression().prefix_expression().postfix_expression();
                java_if += fctc.function_call_argument_clause().function_call_argument_list().function_call_argument(0).expression().getText();
                java_if += "); \n";
                java_if += visitCode_block(ctx.code_block());
                return java_if;
            }
            java_if += " if(";
            //java_if += ctx.condition_list().getText() ;
        try {
            java_if += visitCondition_list(ctx.condition_list());
        }catch(Exception e){
            java_if+="TCIOSACERROR ";
            java_if+=visitCondition_list(ctx.condition_list());
            //java_if+= ctx.condition_list().getText();
            Swift3Parser.Function_call_expressionContext fctc = (Swift3Parser.Function_call_expressionContext) ctx.condition_list().condition(0).optional_binding_condition().initializer().expression().prefix_expression().postfix_expression();
            java_if += fctc.function_call_argument_clause().function_call_argument_list().function_call_argument(0).expression().getText();
        }
            java_if += ") ";

            java_if += "{\n";
            java_if += visitCode_block(ctx.code_block());
            java_if += "\n}\n";
            if (ctx.else_clause() != null)
                java_if += visitElse_clause(ctx.else_clause());

            return java_if;
//        }catch (Exception e){
//            return ctx.getText();
//        }
    }
    @Override
    public String visitCondition_list(Swift3Parser.Condition_listContext ctx) {
        String Java_condition_list = "";

        for(int  i = 0; i < ctx.condition().size(); i++ )
            try {
                Java_condition_list += visitCondition(ctx.condition(i));
            }catch(Exception e){
                Java_condition_list+="TCIOSACERROR ";
                Java_condition_list+=ctx.condition(i).getText();
            }

        return Java_condition_list;
    }


    @Override
    public String visitCondition(Swift3Parser.ConditionContext ctx) {
        try {
            String Java_condition = "";

            Java_condition += visitExpression(ctx.expression());

            return Java_condition;
        }catch (Exception e){
            return "TCIOSACERROR "+ visitExpression(ctx.expression());
        }
    }

    @Override
    public String visitElse_clause(Swift3Parser.Else_clauseContext ctx) {
        String java_else ="";
        if (ctx.if_statement()!= null)
        {
            java_else += "else";
            java_else += visitIf_statement(ctx.if_statement());
        }
        else {
            java_else += "else";
            java_else += "{\n";
            java_else += visitCode_block(ctx.code_block());
            java_else += "\n}";
        }
        return java_else;
    }
    @Override
    public String visitSwitch_statement(Swift3Parser.Switch_statementContext ctx) {
        String java_switch="";
        java_switch += "switch (";
        java_switch += ctx.expression().getText() + ") ";
        java_switch+="\n{\n";
        java_switch+=visitSwitch_cases(ctx.switch_cases());
        java_switch+="\n}";
        return java_switch;
    }

    @Override
    public String visitSwitch_cases(Swift3Parser.Switch_casesContext ctx) {
        String java_cases="";
        java_cases+=visitSwitch_case(ctx.switch_case());
        if(ctx.switch_cases()!=null)
        {
            java_cases+=visitSwitch_cases(ctx.switch_cases());
        }
        return java_cases;
    }

    @Override
    public String visitSwitch_case(Swift3Parser.Switch_caseContext ctx) {
        String java_case="";
        if(ctx.case_label()!=null)
            java_case+=ctx.case_label().getText()+"\n";
        if(ctx.default_label()!=null)
            java_case+=ctx.default_label().getText()+"\n";
        if(ctx.statements()!=null)
            java_case+=visitStatements(ctx.statements());

        return java_case;
    }

    @Override
    public String visitVariable_declaration(Swift3Parser.Variable_declarationContext ctx) {
        String javaVariableDeclaration = "";
        String tmp = "";
        tmp = visitPattern_initializer_list(ctx.pattern_initializer_list());

        /** Soliman **/
        /* In this condition we check if the variable declaration contains a boolean or not. */
        /* we use it just to store the boolean state to use its counter for the switch(Toggle) statement */
        /* Java Tracing Statement: boolean vibrateOnRing  = false */
        if(tmp.contains("boolean")){//Checking if (boolean vibrateOnRing  = false) contains "boolean"
            String variableDeclaration="";
            String declarationIdentifier="";
            String declarationValue="";

            variableDeclaration=tmp;//boolean vibrateOnRing  = false
            variableDeclaration = variableDeclaration.replace("boolean ","");//vibrateOnRing  = false
            declarationIdentifier = variableDeclaration.substring(0,variableDeclaration.indexOf(" "));//vibrateOnRing
            declarationValue = variableDeclaration.substring(variableDeclaration.lastIndexOf(" ")+1,variableDeclaration.length());//false

            BooleanHM.put(declarationIdentifier,declarationValue);//Adding (vibrateOnRing, false) to BooleanHM to use it later on the switch(Toggle) conversion
        }

//        System.out.println("739"+ctx.getText());
        if (!tmp.contains("body"))
        {

            javaVariableDeclaration += tmp;

//            System.out.println("743"+javaVariableDeclaration);
            return (javaVariableDeclaration+";");

        }

        return (javaVariableDeclaration +";");
    }

    @Override
    public String visitPattern_initializer_list(Swift3Parser.Pattern_initializer_listContext ctx) {
        String javaCode = "";
//       System.out.println("7453"+ctx.getText());
try {
    //todo implement list

    for (int i = 0; i < ctx.pattern_initializer().size(); i++) {
        javaCode += visitPattern_initializer(ctx.pattern_initializer(i));

//            System.out.println("757"+javaCode);
        if (i != (ctx.pattern_initializer().size()) - 1)
            javaCode += ",";
    }
    //      System.out.println("1092"+javaCode);
}catch(Exception e){javaCode+="TCIOSAC";}
        return javaCode;
    }

    @Override
    public String visitPattern_initializer(Swift3Parser.Pattern_initializerContext ctx) {
        String Java_patern = "";


        if (Java_patern.isEmpty()&& closure_statement_flag)
        {


            String swift_return_dataType="";
            int start_index,end_index;

            end_index=ctx.getText().indexOf("=");

            start_index = ctx.getText().indexOf("->")+2;


            swift_return_dataType= ctx.getText().substring(start_index,end_index);


            if(DataBaseResources.getJavaDataType(swift_return_dataType) != null)
                Java_patern = DataBaseResources.getJavaDataType(swift_return_dataType)  ;
            else
                Java_patern = swift_return_dataType;

            /*if(swift_return_dataType.contains("Int"))
            javatype= "int";
            else if(swift_return_dataType.contains("Float") )
                javatype= "float";
           else if(swift_return_dataType.contains("String"))
                javatype= "String";
            else if(swift_return_dataType.contains("Bool"))
                javatype= "boolean";
            else if(swift_return_dataType.contains("Double"))
                javatype= "double";
            else if(swift_return_dataType.contains("char"))
                javatype= "char";*/

            Java_patern+= " performOperation( ";
            //I need to  check how many parameters are present.
            //suggetions: for loop
            /*Swift3Parser.The_function_typeContext pctx = (Swift3Parser.The_function_typeContext) ctx.getChild(1);

            visitThe_function_type(pctx);*/
            closure_var_names_flag = true; //direct the code toward the var names in closure statements
           ;


            visitPattern(ctx.pattern());

            visitInitializer(ctx.initializer());


             for(int i=0,j=1;i<parameters_closure_dataTypes.size();i++){

                 Java_patern += parameters_closure_dataTypes.get(i);
                 Java_patern += " ";
                 Java_patern += parameters_closure_variables.get(i);
                 if(j<parameters_closure_dataTypes.size()) {//to prevent the last comma to be printed
                     Java_patern += ",";
                     j++;
                 }

             }

            Java_patern += ")";
            Java_patern += ";";
            Java_patern += "\n";
            Java_patern+="Operation ";

            closure_statement_flag= false;

        }





        if(ctx.pattern().type_annotation() == null)
        {

            String dummy_pattern = "";

            dummy_pattern = visitInitializer(ctx.initializer());

            if (java_readline != "")
                Java_patern+= java_readline;
            else {
                if (!dic_import_flag) {

                  if(class_name_dataType != null)
                      if(!(ctx.getText().contains("(") ||ctx.getText().contains("=")))
                          if (class_name_dataType.equals(ctx.getText().substring(ctx.getText().indexOf("=") + 1, ctx.getText().indexOf("(")).trim()))
                                literal_type = class_name_dataType;

                  Java_patern += literal_type + "";


                  if (array_dic_brackets_flag) {

                            Java_patern += "[]";

                            array_dic_brackets_flag = false;
                           // System.out.println("1194"+Java_patern);
                        }
                }
            }

        }

        if(dic_import_flag){

            Java_patern+= "Map<"+ dic_key_value_dataTypes_array.get(0)+","+dic_key_value_dataTypes_array.get(1)+">";
        }
        Java_patern += visitPattern(ctx.pattern());

        //   System.out.println("768"+Java_patern);



        if (ctx.initializer()==null)
        {

            return Java_patern;
        }

        Java_patern += visitInitializer(ctx.initializer());

        if(dic_import_flag){
            Java_patern+="\n";
            for(int i=0;i<dic_key_array.size();i++){
                Java_patern+= ctx.pattern().getText()+".put(";
                Java_patern+=dic_key_array.get(i)+","+dic_value_array.get(i)+")";
                if(i<dic_key_array.size()-1) {//by samer: to remove the last semicolon as it is already put in Java const.
                    Java_patern += ";";
                    Java_patern += "\n";
                }

            }


        }
//        System.out.println("776"+Java_patern);
        if(closure_return_flag == true){
            Java_patern +=" (";
            for(int i=0,j=1;i<parameters_closure_dataTypes.size();i++){

                Java_patern += parameters_closure_variables.get(i);
                Java_patern += " ";

                if(j<parameters_closure_dataTypes.size()) {//to prevent the last comma to be printed
                    Java_patern += ",";
                    j++;
                }

            }
            Java_patern +=") ";
            Java_patern += ctx.initializer().expression().getText().substring(ctx.initializer().expression().getText().indexOf("return")+6,ctx.initializer().expression().getText().indexOf("}"));//by samer: I used the substring to remove the extra semicolon at the end
            closure_return_flag=false;
        }

        return Java_patern;
    }

    @Override
    public String visitPattern(Swift3Parser.PatternContext ctx) {
        //try {
            String j_pattern = "";


//new
        try {


            //if(ctx.type_annotation()!=null)


           // if(ctx.type_annotation()==null ){

            //}
//we make this as one if and one else if.


            if(ctx.expression_pattern()!= null)
            {

                j_pattern += visitExpression_pattern(ctx.expression_pattern());
            }
            else if(ctx.type_annotation()!=null) {

                if (Swift3Parser.The_array_typeContext.class.isInstance(ctx.type_annotation().type())) {
                    String array_identifier = ctx.type_annotation().type().getText();
                    array_identifier = array_identifier.substring(1, array_identifier.length() - 1);
                    String javatype = DataBaseResources.getJavaDataType(array_identifier);
                    j_pattern += javatype;
                    j_pattern += "[]";

                } else if (ctx.type_annotation().getText().contains("Array")) {
                    j_pattern += "ArrayList<";

                    int l = ctx.type_annotation().getText().length();
                    array_type = ctx.type_annotation().getText().substring(7, l - 1);
                    String javatype = DataBaseResources.getJavaDataType(array_type);
                    j_pattern += javatype + ">";
                    array_type = j_pattern;
                } else {

                    j_pattern += visitType_annotation(ctx.type_annotation());

                }
            }


            //Todo refactor annotation
           // String c = visitType_annotation(ctx.type_annotation());
            if(ctx.identifier_pattern() != null)
            {

                j_pattern += " ";
                j_pattern += visitIdentifier_pattern(ctx.identifier_pattern());

                swiftTypeIDentifier.put(swift_identifier, swiftType);


                j_pattern += " ";

            }

            return j_pattern;

        }catch (Exception e){

            return "TCIOSACERROR Pattern"+ctx.getText();
        }
    }


    @Override
    public String visitExpression_pattern(Swift3Parser.Expression_patternContext ctx) {
        String java_expression ="";
        java_expression += visitExpression(ctx.expression());
        return java_expression;
    }

    @Override
    public String visitType_annotation(Swift3Parser.Type_annotationContext ctx)
    {

try {
    if (!closure_statement_flag) {//modification by samer: this condition based on a flag that is raised in constant declaration to prevent catching error in pattern
        Swift3Parser.The_type_identifierContext datactx = (Swift3Parser.The_type_identifierContext) ctx.type();

        swiftType = datactx.type_identifier().type_name().getText();

    }

}catch(Exception e){

    };
        String javatype ="";

        if(ctx.type().getChild(0).getText().contains("["))
        {
            if(ctx.type().getChild(0).getChild(1) != null)
             swiftType = ctx.type().getChild(0).getChild(1).getText();

            javatype += DataBaseResources.getJavaDataType(swiftType) + "[]";
        }
        else
        javatype += DataBaseResources.getJavaDataType(swiftType);

        if (javatype == null && classlist.contains(swiftType))
        {
            class_flag =1;
            javatype=swiftType;
        }
        else if (javatype == null && closure_statement_flag)
        {
            String swift_return_dataType="";
            int start_index,end_index;

            end_index=ctx.getText().length();

            start_index = ctx.getText().indexOf("->")+2;


            swift_return_dataType= ctx.getText().substring(start_index,end_index);
            if(DataBaseResources.getJavaDataType(swift_return_dataType) != null)
                javatype = DataBaseResources.getJavaDataType(swift_return_dataType);
            else
                javatype = swift_return_dataType;
            /*if(swift_return_dataType.contains("Int"))
            javatype= "int";
            else if(swift_return_dataType.contains("Float") )
                javatype= "float";
           else if(swift_return_dataType.contains("String"))
                javatype= "String";
            else if(swift_return_dataType.contains("Bool"))
                javatype= "boolean";
            else if(swift_return_dataType.contains("Double"))
                javatype= "double";
            else if(swift_return_dataType.contains("char"))
                javatype= "char";*/

          //  javatype+= " performOperation( ";
            //I need to  check how many parameters are present.
            //suggetions: for loop

               Swift3Parser.The_function_typeContext pctx = (Swift3Parser.The_function_typeContext) ctx.getChild(1);
                visitThe_function_type(pctx);

               closure_statement_flag=false;


        }

        if(ctx.getText().contains("->")&& ctx.getText().startsWith(":"))
            javatype="";

        return javatype;

    }

    @Override
    public String visitThe_function_type(Swift3Parser.The_function_typeContext ctx) {
        visitFunction_type(ctx.function_type());

        return "";
    }

    @Override
    public String visitFunction_type(Swift3Parser.Function_typeContext ctx) {


        visitFunction_type_argument_clause(ctx.function_type_argument_clause());


        return"";
    }

    @Override
    public String visitFunction_type_argument_clause(Swift3Parser.Function_type_argument_clauseContext ctx) {
        visitFunction_type_argument_list(ctx.function_type_argument_list());
        return "";
    }

    @Override
    public String visitFunction_type_argument_list(Swift3Parser.Function_type_argument_listContext ctx) {
        parameters_closure_dataTypes.add(visitFunction_type_argument(ctx.function_type_argument())) ;
        if(ctx.function_type_argument_list() != null) {

            visitFunction_type_argument_list(ctx.function_type_argument_list());

        }

        //System.out.println(parameters_closure_dataTypes);
        return "";
    }

    @Override
    public String visitFunction_type_argument(Swift3Parser.Function_type_argumentContext ctx) {
        String closure_para_datatype="";
        closure_para_datatype= ctx.getText();

        return closure_para_datatype;
    }

    @Override
    public String visitIdentifier_pattern(Swift3Parser.Identifier_patternContext ctx) {
        String java_identifier = "";
        swift_identifier = ctx.declaration_identifier().getText();


        //if(!swift_identifier.contains("body"))
        java_identifier += swift_identifier;

        return java_identifier;
    }

    @Override
    public String visitInitializer(Swift3Parser.InitializerContext ctx) {

       int dic_ctr_counter=0; //this counter will prevent the ruin of the array

        String java_initializer = "";
        java_initializer +=" ";

            java_initializer += ctx.assignment_operator().getText();




            String arraydict_expression = ctx.expression().getText();


        if(arraydict_expression.startsWith("[")==true) {
            if(visitExpression(ctx.expression()).isEmpty()) {//by samer: if its a dictionary I made it return an empty text so I used this condition
                //dictionary

                   java_initializer+= "new HashMap<>();";

                     //  for (int i = 0; i < dic_key_array.size(); i++)//by samer: this loop is to remove the repeated indexes in the array of the keys of the dictionary
                      // {
                          // for (int j = 1; j < dic_key_array.size(); j++) {
                           //    if (dic_key_array.get(i) == dic_key_array.get(j)) {
                         //          dic_key_array.remove(j);
                         //      }
                        //   }

                       //}

                     //  for (int i = 0; i < dic_value_array.size(); i++)//by samer: this loop is to remove the repeated indexes in the array of the values of the dictionary
                     //  {
                        //   for (int j = 1; j < dic_value_array.size(); j++) {
                        //       if (dic_value_array.get(i) == dic_value_array.get(j))
                         //          dic_value_array.remove(j);
                         //  }

                     //  }




            }
          else
            {
                java_initializer += "{";
                //array_expression=array_expression.substring(1,array_expression.length()-1)+"}";
                java_initializer += visitExpression(ctx.expression());
                java_initializer += "}";

            }

            //java_initializer+=array_expression;
            return java_initializer;
        }

        else if (arraydict_expression.startsWith("Array()")){
            java_initializer+=" new "+array_type+"()";
            return java_initializer;
        }
        else if (class_flag== 1)
        {
            java_initializer += " new ";
            if(ctx.expression()!=null)
                java_initializer += visitExpression(ctx.expression());
            else
                java_initializer+="()";
            class_flag=0;
        }

        else {

            java_initializer += " ";


//            System.out.println("889"+ java_initializer);
           if(!closure_before_return_exp_flag)// to prevent the (a,b) after a*b in closue statement
            java_initializer += visitExpression(ctx.expression());
           else
               visitExpression(ctx.expression());
//            System.out.println("891"+ java_initializer);

        }

        return java_initializer;
    }

    @Override
    public String visitExpression(Swift3Parser.ExpressionContext ctx) {
        //try {
            String java_expression = "";

            //the flag is raised by samer
        if(ctx.getText().contains("readLine()")){
            exp_readline_flag =true;

        }
//---------------------------------------------------------


        java_expression += visitPrefix_expression(ctx.prefix_expression());

            if (ctx.binary_expressions() != null) {

                if (text_flag) {
                    text_flag = false;

                    int i = 0;
                    for (i = 0; i < ctx.binary_expressions().binary_expression().size(); i++) {
                        java_expression += visitPrefix_expression(ctx.binary_expressions().binary_expression(i).prefix_expression());

                        if (i != ctx.binary_expressions().binary_expression().size() - 1)
                            java_expression += " + ";

                    }
                    java_expression += ")";


                } else {

                  if(!ctx.getText().contains(".."))//modification by samer to remove the ..5 to be written in the for loop
                  {

                      java_expression += visitBinary_expressions(ctx.binary_expressions());
                  }

                  else {

                      java_expression += ";";
                      java_expression+=for_iterator;
                      if(ctx.getText().contains("<")){
                          java_expression+=" < ";

                      }else
                          java_expression+=" <= ";

                      java_expression+=ctx.binary_expressions().binary_expression(0).prefix_expression().getText();
                      java_expression+="; ";
                      java_expression+=for_iterator;
                      java_expression+="++)";
                  }
                }
            }

            if(ctx.prefix_expression().postfix_expression() == null)
            {


            }
//        System.out.println("917"+java_expression);

            return java_expression;
//        }catch(Exception e){
//            return "TCIOSACERROR "+ctx.getText();
//        }
    }

    @Override
    public String visitBinary_expressions(Swift3Parser.Binary_expressionsContext ctx) {
        String java_binary_expressions = "";

        for (int i=0; i < ctx.binary_expression().size(); i++)
            java_binary_expressions+= visitBinary_expression(ctx.binary_expression(i));

        return java_binary_expressions;
    }

    @Override
    public String visitBinary_expression(Swift3Parser.Binary_expressionContext ctx) {
        String java_binary= "";

        java_binary += " " + ctx.binary_operator().getText()+" ";

        java_binary += visitPrefix_expression(ctx.prefix_expression());

        return java_binary;
    }

    @Override
    public String visitPrefix_expression(Swift3Parser.Prefix_expressionContext ctx) {
        String Java_prefix = "";
  //System.out.println(ctx.getText()+"$$$$$$$$$");

                if(ctx.getText().startsWith("openURL")){
                    openURL_flag = true;
                }
                /** Soliman **/
                /* Checking for Button_URL and getting its text */
                if(openURL_flag&&ctx.getText().startsWith("URL")&&ctx.getText().contains("!")&&!Button_flag){
                    /** UNDO **/
                    Button_URL_flag = true;
                   /** UNDO **/
                    Button_URLText = ctx.getText().substring(ctx.getText().indexOf(":")+1,ctx.getText().indexOf("!")-1);
//                    System.out.println(Button_URLText);
                    Button_URL_counter++;
                    openURL_flag = false;
                }

//        System.out.println(ctx);
                if(ctx.getText().contains("URL")){
                    URL_link = ctx.getText().substring(ctx.getText().indexOf("\""),ctx.getText().lastIndexOf("\"")+1);
                    URL_Link_flag = true;
                }
            //try {

                if (ctx.prefix_operator() != null) {

                    Java_prefix += ctx.prefix_operator().getText();

                }

        //Swift3Parser.Postfix_operationContext postopr = (Swift3Parser.Postfix_operationContext )ctx.postfix_expression();
        //System.out.println(postopr+"&&&&&&&6");
                if (ctx.getText().contains("stride")) {
                    for_flag = 1;

                    Java_prefix += visit(ctx.postfix_expression());


                }



        //This is writing if we like to visit Primary directly
                else if (Swift3Parser.PrimaryContext.class.isInstance(ctx.postfix_expression())) {

                    //modification by samer. I added the if statetment to make sure that the variable name is written because the condition in the else return null
                  if(exp_readline_flag) {
                      Java_prefix += ctx.getText();
                      exp_readline_flag=false;

                  }
                  else {

                      Swift3Parser.PrimaryContext pctx = (Swift3Parser.PrimaryContext) ctx.postfix_expression();
//                    System.out.println("958"+ pctx.getText());
                      Java_prefix += visitPrimary(pctx);
                      System.out.println();


                  }
                }
                else if (Swift3Parser.Function_call_expression_with_closureContext.class.isInstance(ctx.postfix_expression()))
                {

                    Swift3Parser.Function_call_expression_with_closureContext fcctx = (Swift3Parser.Function_call_expression_with_closureContext) ctx.postfix_expression();
                    Java_prefix += visitClosure_expression(fcctx.trailing_closure().closure_expression());
                }
                else if (Swift3Parser.Function_call_expressionContext.class.isInstance(ctx.postfix_expression())) {

                    Swift3Parser.Function_call_expressionContext fnctx = (Swift3Parser.Function_call_expressionContext) ctx.postfix_expression();

                    if (fnctx.function_call_argument_clause().function_call_argument_list() != null)
                    {

                        /*if(fnctx.function_call_argument_clause().function_call_argument_list().function_call_argument(0).expression() != null) //We don't know why we did it
                        {
                            Java_prefix += visitExpression(fnctx.function_call_argument_clause().function_call_argument_list().function_call_argument(0).expression());
                        }*/
                        if (fnctx.function_call_argument_clause().function_call_argument_list().function_call_argument(0).expression().binary_expressions() != null && !ctx.getText().contains("readLine()??")) {//modify by samer: the second condition is to prevent the entry of this condition at the case of let boolValue = Bool(readLine() ?? "")
                            binary_flag = true;

                        }
                    }
                    if (fnctx.getText().contains("AudioServicesPlayAlertSound") && fnctx.getText().contains("kSystemSoundID_Vibrate")) {
                        Java_prefix += "Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);\n" +
                                "            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {\n" +
                                "               vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));\n" +
                                "            } else {\n" +
                                "               vibrator.vibrate(500);\n" +
                                "            }";
                        return Java_prefix;
                    }
                    if (Swift3Parser.PrimaryContext.class.isInstance(fnctx.postfix_expression())) {

                        //modification by samer : it will work for string now. (don't forget to add another flags for the other datatypes)
                        if(ctx.getText().contains("readLine()"))
                        {
                            if(ctx.getText().contains("Int(")){
                                Java_prefix+="scanner.nextInt(";
                                java_readline= "int";
                            }
                           else if(ctx.getText().contains("Float(")){
                                Java_prefix+="scanner.nextFloat(";

                                java_readline= "float";
                            }
                            else if(ctx.getText().contains("Double(")){
                                Java_prefix+="scanner.nextDouble(";
                                java_readline= "double";
                            }
                            else if(ctx.getText().contains("Bool(")){
                                Java_prefix+="scanner.nextBoolean( ";
                                java_readline= "boolean";
                            }

                            else {
                                Java_prefix += "scanner.nextLine(";
                                java_readline= "String";
                            }

                        }

                        else {

                            Swift3Parser.PrimaryContext pctx = (Swift3Parser.PrimaryContext) fnctx.postfix_expression();
                            Java_prefix += visitPrimary(pctx);

                        }
                        //-------------------------------------------------------------------------------------
                        if (binary_flag) {

                            Java_prefix = Java_prefix.substring(0, Java_prefix.length() - 1);
                            binary_flag = false;
                            Java_prefix += ".valueOf(";
                        }

                    } else if (Swift3Parser.Explicit_member_expression2Context.class.isInstance(fnctx.postfix_expression())) {

                        Swift3Parser.Explicit_member_expression2Context exctx = (Swift3Parser.Explicit_member_expression2Context) fnctx.postfix_expression();
                        if (built_in_methods.getJavamethod(exctx.getText()) != null) {
                            Java_prefix += built_in_methods.getJavamethod(exctx.getText()) + "(";
                        } else {

                            Java_prefix += visitExplicit_member_expression2(exctx);
                        }
                    }

                    if (Java_prefix.contains("Toast")) {
                        toastflag = true;
                        Java_prefix += visitFunction_call_argument_clause(fnctx.function_call_argument_clause()) + ").show()";
                        return Java_prefix;
                    } else if (Java_prefix.contains(("super.onCreate"))) {
                        Java_prefix += "savedInstanceState); \n setContentView(R.layout.activity_main)";
                        return Java_prefix;
                    }
                    //double bracket
                    //else if (fnctx.function_call_argument_clause().getText().contains("()"))

                    if(Old_URL_flag)
                    {

                        Java_prefix += visitFunction_call_argument_clause(fnctx.function_call_argument_clause());
                       // Java_prefix += " = new URL(";
                    }
                    else if(Image_flag)
                    {
                        Java_prefix += visitFunction_call_argument_clause(fnctx.function_call_argument_clause())+Image_counter;
                        Java_prefix += "=(ImageView)findViewById(R.id." + Literal_expression+Image_counter+ ")";
                        XMLImageIdentifier = Literal_expression+Image_counter;
                        XMLImageDescription = Literal_expression;
                        Image_flag = false;
                        Image_counter++;
                        XMLImage_isReady = true;
                    }
                    else if(TextField_flag)
                    {
                        Java_prefix += " simpleEditText" + TextField_counter + " = (EditText) findViewById(R.id.simpleEditText" + TextField_counter + ");\n";
                        String tmp = visitFunction_call_argument_clause(fnctx.function_call_argument_clause());
                        Java_prefix += "simpleEditText" + TextField_counter + ".setText(\"" + Literal_expression + "\")";
                        XMLTextFieldIdentifier = "simpleEditText"+TextField_counter;
                        XMLTextFieldText = Literal_expression;
                        TextField_flag =false;
                        XMLTextField_isReady = true;
                    }
                    else if(SecureField_flag)
                    {
                        Java_prefix += " simpleEditText_SecureField" + SecureField_counter + " = (EditText) findViewById(R.id.simpleEditText" + SecureField_counter + ");\n";
                        String tmp = visitFunction_call_argument_clause(fnctx.function_call_argument_clause());
                        Java_prefix += "simpleEditText_SecureField" + SecureField_counter + ".setText(\"" + Literal_expression + "\")";
                        XMLSecureFieldIdentifier = "simpleEditText_SecureField"+SecureField_counter;
                        XMLSecureFieldText = Literal_expression;
                        SecureField_flag =false;
                        XMLSecureField_isReady = true;
                    }
                    else if(Java_prefix.contains("AlertDialog.Builder"))
                    {
                        Java_prefix += Alert_counter;
                        Java_prefix += " = new AlertDialog.Builder(this);\n"; //We might not need this
                        Java_prefix += "AlertDialog alert" + Alert_counter + " = builder" + Alert_counter + ".create();\n";
                        Java_prefix += "alert" + Alert_counter + ".setTitle(\"";
                        String tmp = visitFunction_call_argument_clause(fnctx.function_call_argument_clause());
                        //Java_prefix += tmp.substring(tmp.indexOf(",")+3, tmp.indexOf(",.")-1);
                        Java_prefix += Alert_message;
                        Java_prefix += "\");\nalert" + Alert_counter +".show()";
                        /** XML **/
                        //System.out.println("postfix_testing" + Alert_counter);
                        XMLAlertIdentifier = "alert"+Alert_counter;
                        XMLAlert_isReady = true;

                    }   /** Soliman **/
                        /* This flag is explained at the end of the block and the ReadMe.txt file */
                    else if(Button_flag && !Button_Action_Inprogress_wait_flag){

                        Java_prefix += " button"+Button_counter+" = (Button) findViewById(R.id.button"+Button_counter+");\n";
                        visitFunction_call_argument_clause(fnctx.function_call_argument_clause());//Calling it to initiate the Button action conversion process in (visitFunction_argument_list())

                        if(Button_HCLE_flag){//This condition is meant to check whether the HardcodedLiteral_Expression or the Literal_expression is going to be assigned to the SwitchText
                            ButtonText = HardCodedLiteral_Expression;
                            Button_HCLE_flag = false;
                        }else{
                            ButtonText = Literal_expression;
                        }
                        if(!ButtonText.contains("\"")&&!ButtonText.contains("\'")){//Checking if the text contains quotes.
                            ButtonText="\""+ButtonText+"\"";
                        }

                        Java_prefix += "button"+Button_counter+".setText("+ ButtonText +");\n";
                        Java_prefix += "button"+Button_counter+".setOnClickListener(new View.OnClickListener(){\n";
                        Java_prefix += "\tpublic void onClick(View view){\n";
                        Java_prefix += "\t\t"+Button_Action+"\n";
                        Java_prefix += "\t}\n";
                        Java_prefix += "})";

                        Button_flag = false;//Indicating that the Button conversion process is terminated.
                        XMLButtonIdentifier = "button"+Button_counter;//Fetching Button identifier for XML conversion.
                        XMLButtonText = ButtonText;//Fetching Button text for XML conversion.
                        XMLButton_isReady = true;//Indicates that the Java conversion process is done and all the need attributes or parameters are collected, and initiate the XML conversion process.


                    } /** soliman**/
                    else if(Switch_flag ){//Checking whether a switch component has been detected or not.
                        Java_prefix += " switch"+Switch_counter+" = (Switch) findViewById(R.id.Switch"+Switch_counter+");\n";
                        visitFunction_call_argument_clause(fnctx.function_call_argument_clause());//Calling it to initiate the Switch action conversion process in (visitFunction_argument_list())

                        if(Switch_HCLE_flag){//This condition is meant to check whether the HardcodedLiteral_Expression or the Literal_expression is going to be assigned to the SwitchText
                            SwitchText = HardCodedLiteral_Expression;
                            Switch_HCLE_flag = false;
                        }else{
                            SwitchText = Literal_expression;
                        }
                        if(!SwitchText.contains("\"")&&!SwitchText.contains("\'")){//Checking if the text contains quotes.
                            SwitchText="\""+SwitchText+"\"";
                        }

                        Java_prefix += "switch"+Switch_counter+".setText("+ SwitchText +");\n";
                        Java_prefix += "switch"+Switch_counter+".setOnClickListener(new View.OnClickListener(){\n";
                        Java_prefix += "\tpublic void onClick(View view){\n";
                        Java_prefix += "\t\t"+Switch_Action+"\n";
                        Java_prefix += "\t}\n";
                        Java_prefix += "})";

                        Switch_flag = false;//Indicating that the Switch conversion process is terminated.
                        XMLSwitchIdentifier = "switch"+Switch_counter;//Fetching Switch identifier for XML conversion.
                        XMLSwitchText = SwitchText;//Fetching Switch text for XML conversion.
                        XMLSwitch_isReady = true;//Indicates that the Java conversion process is done and all the need attributes or parameters are collected, and initiate the XML conversion process.
                    }
                    else if(URL_flag){
                        Java_prefix += "Button urlButton"+URL_counter+" = (Button) findViewById(R.id.urlButton"+URL_counter+");\n";

                        visitFunction_call_argument_clause(fnctx.function_call_argument_clause());

                        if(URL_HCLE_flag){//This condition is meant to check whether the HardcodedLiteral_Expression or the Literal_expression is going to be assigned to the SwitchText
                            URLText = HardCodedLiteral_Expression;
                            URL_HCLE_flag = false;
                        }else{
                            URLText = Literal_expression;
                        }
                        if(!URLText.contains("\"")&&!URLText.contains("\'")){//Checking if the text contains quotes.
                            URLText="\""+URLText+"\"";
                        }

                        Java_prefix += "urlButton"+URL_counter+".setText("+URLText+");\n";
                        Java_prefix += "urlButton"+URL_counter+".setOnClickListener(new onClickListener() {\n";
                        Java_prefix += "\t@Override\n";
                        Java_prefix += "\tpublic void onClick(View view) {\n";
                        Java_prefix += "\t\tString url = "+URL_link+";\n";
                        Java_prefix += "\t\tIntent i = new Intent(Intent.ACTION_VIEW);\n";
                        Java_prefix += "\t\ti.setData(Uri.parse(url));\n";
                        Java_prefix += "\tstartActivity(i);\n";
                        Java_prefix += "}\n";
                        Java_prefix += "})";

                        URL_flag = false;
                        XMLURLIdentifier = "urlButton"+URL_counter;
                        XMLURLText = URLText;

                    }
                    else if(fnctx.function_call_argument_clause()!=null)
                    {

                        if(TextEdit_flag){ //so it doesn't add the (

                            Java_prefix += visitFunction_call_argument_clause(fnctx.function_call_argument_clause());
                        }
                        else
                        {

                            /** Soliman **/
                            /* I commenteed the line below Because it was adding an extra left parenthesis to my action in the Button action attribute */

//                            Java_prefix += "(";
                            Java_prefix += visitFunction_call_argument_clause(fnctx.function_call_argument_clause()) ;

                        }
                    }
                    /** Soliman **/
                    /* Button_YRL conversion function */
                    if (Button_URL_isReady) {

                        Java_prefix = Java_prefix.substring(0,Java_prefix.length()-1);//This is used to remove an extra ")" before the button declaration.
                        Java_prefix += "Button ButtonURL"+Button_URL_counter+" = (Button) findViewById(R.id.ButtonURL"+Button_URL_counter+");\n";

                        if(!Button_URLText.contains("\"")&&!Button_URLText.contains("\'")){//Checking if the text contains quotes.
                            URLText="\""+Button_URLText+"\"";
                        }
                        if(!Button_URL_Link.contains("\"")&&!Button_URL_Link.contains("\'")){//Checking if the text contains quotes.
                            URLText="\""+Button_URL_Link+"\"";
                        }

                        Java_prefix += "ButtonURL"+Button_URL_counter+".setText("+Button_URLText+");\n";
                        Java_prefix += "ButtonURL"+Button_URL_counter+".setOnClickListener(new onClickListener() {\n";
                        Java_prefix += "\t@Override\n";
                        Java_prefix += "\tpublic void onClick(View view) {\n";
                        Java_prefix += "\t\tString url = "+Button_URL_Link+";\n";
                        Java_prefix += "\t\tIntent i = new Intent(Intent.ACTION_VIEW);\n";
                        Java_prefix += "\t\ti.setData(Uri.parse(url));\n";
                        Java_prefix += "\tstartActivity(i);\n";
                        Java_prefix += "}\n";
                        Java_prefix += "})";

                        Button_URL_isReady = false;
                        Button_URL_flag = false;
                    }else if(ProgressBar_flag){
                       // visitFunction_call_argument_clause(fnctx.function_call_argument_clause());

                        Java_prefix = "ProgressBar progressBar"+ProgressBar_counter+" = (ProgressBar) findViewById(R.id.progressBar"+ProgressBar_counter+");\n";
                        Java_prefix += "progressBar"+ProgressBar_counter+".setMax("+ProgressBar_Max+");\n";
                        Java_prefix += "progressBar"+ProgressBar_counter+".setProgress("+ProgressBar_Progress+");\n";
                        Java_prefix += "TextView PBTextView"+ProgressBar_counter+" = (TextView) findViewById(R.id.PBTextView"+ProgressBar_counter+");\n";
                        Java_prefix += "PBTextView.setText("+ProgressBarText+")";

                        ProgressBar_flag = false;
                        XMLProgressBarIdentifier = "progressBar"+ProgressBar_counter;
                        XMLPBTextViewIdentifier = "PBTextView"+ProgressBar_counter;
                        XMLPBTextViewText = ProgressBarText;
                        XMLProgressBarMax = ProgressBar_Max;
                        XMLProgressBarProgress = ProgressBar_Progress;
                        XMLProgressBar_isReady = true;
                    }

                    if (Intentflag) {
                        Intentflag = false;
                        Java_prefix += ";\n" + " startActivity(intent)";

                    }

                } else if (Swift3Parser.Subscript_expressionContext.class.isInstance(ctx.postfix_expression())) {

                    Swift3Parser.Subscript_expressionContext subctx = (Swift3Parser.Subscript_expressionContext) ctx.postfix_expression();
                    Java_prefix += subctx.postfix_expression().getText();
                    Java_prefix += ".get(";
                    Java_prefix += subctx.expression_list().getText() + ")";
                } else if (ctx.getText().contains("self")) {

                    Java_prefix += "this.";
                    Swift3Parser.Explicit_member_expression2Context ectx = (Swift3Parser.Explicit_member_expression2Context) ctx.postfix_expression();
                    String builtin = ectx.declaration_identifier().getText();
                    String Javabuiltin = built_in_methods.getJavamethod(builtin);
                    if (Javabuiltin != null) {
                        Java_prefix += Javabuiltin;
                        if (Javabuiltin.contains("Math")) {
                            Java_import += "import java.lang.Math;";

                        }

                    } else
                        Java_prefix += builtin;
                } else if (Swift3Parser.Explicit_member_expression2Context.class.isInstance(ctx.postfix_expression())) {

                    Swift3Parser.Explicit_member_expression2Context exctx = (Swift3Parser.Explicit_member_expression2Context) ctx.postfix_expression();
                    if (ctx.postfix_expression().getText().contains("text!"))
                        exclamation_tag = true;

                    Java_prefix += visitExplicit_member_expression2(exctx);

                    if (text_flag == true) {
                        return Java_prefix;
                    }

                    Java_prefix += ")";
                } else if (ctx.getText().contains("text!")) {
                    exclamation_tag = true;
                    Swift3Parser.Postfix_operationContext pctx = (Swift3Parser.Postfix_operationContext) ctx.postfix_expression();
                    if (Swift3Parser.Explicit_member_expression2Context.class.isInstance(pctx.postfix_expression())) {
                        Swift3Parser.Explicit_member_expression2Context ectx = (Swift3Parser.Explicit_member_expression2Context) pctx.postfix_expression();
                        Java_prefix += visitExplicit_member_expression2(ectx);
                    }

                    return Java_prefix + ")";

                } else
                {

                    //modification by samer to remove the text inside the brackets in case of Int(readLine()!) and the other cases
                   if(ctx.getText().contains("readLine()")){

                   }
                    else {

                       Java_prefix += ctx.getText();

                   }
                }
       if(Java_prefix.contains("System.out.println("))
        Java_prefix+=")";

                return Java_prefix;
//            }catch(Exception e){
//                return "TCIOSACERROR "+ctx.getText();
//            }
    }

    @Override
    public String visitExplicit_member_expression2(Swift3Parser.Explicit_member_expression2Context ctx) {
        //try {
            String java_explicit = "";

            java_explicit += ctx.postfix_expression().getText();

            java_explicit += ".";

            caller = ctx.postfix_expression().getText();
            String builtin = ctx.declaration_identifier().getText();

            if (exclamation_tag) {

                exclamation_tag = false;
                builtin += "!";
            }
            if (builtin.contains("insert")) {
                insert_flag = true;
            }
            if (builtin.contains("text")) {

                text_flag = true;
            }
            String Javabuiltin = "";
            String javacaller = swiftTypeIDentifier.get(caller);

            if (javacaller != null) {
                //System.out.println(javacaller+ "  " +builtin);
                if (FunctionsInJava.getJavafunctions(javacaller, builtin) != null) {

                    Javabuiltin = FunctionsInJava.getJavafunctions(javacaller, builtin) ;


                }
            } else {

                Javabuiltin = built_in_methods.getJavamethod(builtin);


            }

            //double brackets
            //System.out.println(builtin);
            if (Javabuiltin != null) {
               // System.out.println(Javabuiltin);
                java_explicit += Javabuiltin;

            }
            else {
                java_explicit += builtin;
                java_explicit += "(";
            }


            return java_explicit;
        //}catch(Exception e){
          //  return "TCIOSACERROR "+java_explicit;
        //}
    }

    @Override
    public String visitPostfix_operation(Swift3Parser.Postfix_operationContext ctx) {
        String Java_operation="";


        Java_operation+=visit(ctx.postfix_expression());
        Java_operation+=ctx.postfix_operator().getText();

        return Java_operation;
    }

    @Override
    public String visitPrimary(Swift3Parser.PrimaryContext ctx) {

        String Java_primary="";
        if(URL_flag){
            URL_Text_flag = true;
            URLText = ctx.getText();
        }

        if(closure_var_names_flag) {

            visitClosure_expression(ctx.primary_expression().closure_expression());
        }
        if(ctx.primary_expression().declaration_identifier()!= null) {
            if (ctx.primary_expression().declaration_identifier().keyword_as_identifier_in_declarations() != null) {
                Java_primary += "[";
            }
        }
        if (built_in_methods.getJavamethod(ctx.primary_expression().getText()) != null)
        {
            if(ctx.primary_expression().getText().startsWith("Array"))
                Java_primary +="new ";
            Java_primary += built_in_methods.getJavamethod(ctx.primary_expression().getText()) +"(" ;


            if (Java_primary.contains("Intent"))
            {
                Intentflag=true;
            }


        }
        else if(ctx.primary_expression() != null)
        {

//            System.out.println("1238"+ctx.getText());
            Java_primary += visitPrimary_expression(ctx.primary_expression());

//            System.out.println("!!!!!!!!"+Java_primary);
//            System.out.println("1240"+Java_primary);
            //System.out.println(print_counter++);
            //System.out.println(Java_primary);
        }
        else
        {
            Java_primary += ctx.getText() ;

        }
        if (ctx.getText().contains("print")){
            print_statement_flag = true;
        }

        return Java_primary;
    }

    @Override
    public String visitPrimary_expression(Swift3Parser.Primary_expressionContext ctx) {
        String java_primary_exp =  "";
        String java_type= ctx.getText();


        if(ctx.closure_expression() != null)
        {

            java_primary_exp += visitClosure_expression(ctx.closure_expression());
//            System.out.println("!!!!!!!"+java_primary_exp);

        }
        if(ctx.parenthesized_expression() != null)
        {
            java_primary_exp += visitParenthesized_expression(ctx.parenthesized_expression()) ;
        }
         else if (ctx.literal_expression() != null)
        {
            /** Soliman **/
            /* These conditions are used to overcome the components' multiple literal expressions' problem */
            /* In case we have more than 1 literal expression, we get the literal expression directly from ctx.
            * waiting for the literal expression to get converted and passed through the(java_primary_expression) might lead
            * the literal expressions to get mixed throughout the conversion process. */
            if(Button_HCLE == 2){//Checking if there are more than one literal expression
                Button_HCLE_flag = true;//We indicate that we are going to use the HCLE in the (visitPrefix_Expression) for The Button component
                HardCodedLiteral_Expression = ctx.literal_expression().getText();//Getting the Literal expression directly from the ctx
            }
            Button_HCLE++;//Indicates number of literal expressions

            if(Switch_HCLE == 2){//Checking if there are more than one literal expression
                Switch_HCLE_flag = true;//We indicate that we are going to use the HCLE in the (visitPrefix_Expression) for The Switch component
                HardCodedLiteral_Expression = ctx.literal_expression().getText();//Getting the Literal expression directly from the ctx
            }
            Switch_HCLE++;//Indicates number of literal expressions
            if(URL_HCLE == 2){
                URL_HCLE_flag = true;
                HardCodedLiteral_Expression = ctx.literal_expression().getText();
            }
            URL_HCLE++;

            /*TODO: find better alternatives to (Button_HCLE, Switch_HCLE) */
            /* Priority: LOW */ //depending on the new components.

            java_primary_exp += visitLiteral_expression(ctx.literal_expression());


        }
        else if (ctx.declaration_identifier() != null)
        {


            if(java_type.contains("TextEditor"))
            {

                //System.out.println(java_type);
                TextEdit_flag = true;
                TextEdit_counter++;
                java_primary_exp += DataBaseResources.getJavaDataType(java_type);
                java_primary_exp += " textView" + TextEdit_counter;
                java_primary_exp += " = (TextView) findViewById(R.id.";
                java_primary_exp += "textView" + TextEdit_counter +");\n";
                java_primary_exp += "textView" + TextEdit_counter + ".setText(";
                XMLTextEditorIdentifier = "textView"+TextEdit_counter;
//                System.out.println(java_primary_exp);
            }
            else if(TextEdit_flag)
            {

                /** Soliman **/
                //useless extra space
//                java_primary_exp+= "\"";
                java_primary_exp+= swiftStrings.get(java_type);
                //System.out.println(swiftStrings.get(java_type));
                java_primary_exp+= ")";
                TextEdit_flag = false;
//                System.out.println("@@@"+swiftStrings.get(java_type));
                XMLTextEditorText = swiftStrings.get(java_type);
                XMLTextEditor_isReady = true;
            }
            else if(java_type.contains("TextField"))
            {

                TextField_flag = true;
                TextField_counter++;
                java_primary_exp += DataBaseResources.getJavaDataType(java_type);
            }
            else if(java_type.contains("SecureField")){
                SecureField_flag = true;
                SecureField_counter++;
                java_primary_exp += DataBaseResources.getJavaDataType(java_type);
            }
            else if(java_type.contains("Button")){
                Button_flag = true;
                Button_counter++;
                java_primary_exp += DataBaseResources.getJavaDataType(java_type);
            }
            else if(java_type.contains("Toggle")){
                Switch_flag = true;
                Switch_counter++;
                java_primary_exp += DataBaseResources.getJavaDataType(java_type);
            }
            else if(java_type.contains("Link")){
                URL_flag = true;
                URL_counter++;
                java_primary_exp+= DataBaseResources.getJavaDataType(java_type);
            }else if(java_type.contains("ProgressView")){
                ProgressBar_flag = true;
                ProgressBar_counter++;
                java_primary_exp+=DataBaseResources.getJavaDataType(java_type);
            }
            else if(!java_type.contains("Text"))//why not else statement only?
            {

                java_primary_exp +=  DataBaseResources.getJavaDataType(java_type);

               if(java_primary_exp.contains("null")) {
                   java_primary_exp = "";
                   java_primary_exp += ctx.getText();

               }

            }

            if(java_primary_exp.contains("AlertDialog"))
            {
                java_primary_exp += ".Builder builder";
                Alert_flag = true;
                Alert_counter++;
            }
            if(java_primary_exp.contains("URL_old")) {
                Old_URL_flag = true;
            }
            if(java_primary_exp.contains("ImageView"))
                Image_flag = true;

        }
        else if(DataBaseResources.getJavaDataType(java_type) != null)
        {

            java_primary_exp += DataBaseResources.getJavaDataType(java_type)  + "(";

        }
        /*else{

            java_primary_exp+=java_type;
        }*/

        return java_primary_exp ;
    }

    @Override
    public String visitClosure_expression(Swift3Parser.Closure_expressionContext ctx) {
        String Java_closure = "";
        if(ctx.statements() != null && !closure_var_names_flag)
        {

            Java_closure += visitStatements(ctx.statements());

        }
        if(closure_var_names_flag) {

            visitClosure_signature(ctx.closure_signature());
            closure_var_names_flag = false;
        }
        return Java_closure;
    }

    @Override
    public String visitClosure_signature(Swift3Parser.Closure_signatureContext ctx) {
        visitClosure_parameter_clause(ctx.closure_parameter_clause());

        return "";
    }

    @Override
    public String visitClosure_parameter_clause(Swift3Parser.Closure_parameter_clauseContext ctx) {
        visitClosure_parameter_clause_identifier_list(ctx.closure_parameter_clause_identifier_list());
        return "";
    }

    @Override
    public String visitClosure_parameter_clause_identifier_list(Swift3Parser.Closure_parameter_clause_identifier_listContext ctx) {

        // code here please
        for(int i=0;i< parameters_closure_dataTypes.size();i++) {

            parameters_closure_variables.add(ctx.declaration_identifier(i).getText());

        }

        return "";
    }

    @Override
    public String visitLiteral(Swift3Parser.LiteralContext ctx) {


        String java_literal= "";
        java_literal += ctx.getText();

        if(ctx.boolean_literal() != null)
            literal_type = "boolean";
        else if(ctx.numeric_literal() != null)
        {
            if(ctx.numeric_literal().integer_literal() != null)
                {
                    long holder = Long.parseLong(ctx.getText());
                    if((byte) holder == holder)
                        literal_type= "byte";
                    else if((short) holder == holder)
                        literal_type = "short";
                    else if((int) holder == holder)
                        literal_type = "int";
                    else
                        literal_type = "long";
                }

            else if(ctx.numeric_literal().Floating_point_literal() != null)
            {
                double holder=Double.parseDouble(ctx.getText());
                if( Float.parseFloat(ctx.getText()) == Double.parseDouble(ctx.getText()))
                  literal_type = "float";
                else
                  literal_type = "double";
            }
        }
        else if (ctx.string_literal() != null) {

            literal_type = "String";

        }
        else if(ctx.nil_literal() != null)
            literal_type = null;

        else
            literal_type = ctx.getText();

        return java_literal ;
    }

    @Override
    public String visitLiteral_expression(Swift3Parser.Literal_expressionContext ctx) {

        String java_literal_exp= "";

        if(ctx.getText().startsWith("["))
        {
            array_dic_brackets_flag=true;
       try{
            //dictionary
           if(ctx.dictionary_literal().dictionary_literal_items().dictionary_literal_item().expression().size()==2)//by samer:this condition prevent the array from entering here
                java_literal_exp += visitDictionary_literal(ctx.dictionary_literal());
            }catch (Exception e){
           //array
                java_literal_exp += visitArray_literal(ctx.array_literal());

        }
       }else

            java_literal_exp += visitLiteral(ctx.literal());

//        java_literal = java_literal.substring(1, java_literal.length()-1); //remove the double quotes
        /** Soliman **/
        /* This condition makes sure that the statement that's being converted now isn't a variable or a print statement so that it won't remove its quotes */
        boolean true_flag = true;
        if(java_literal_exp.contains("\"") && !variable_declaration_flag && !print_statement_flag){
            java_literal_exp = java_literal_exp; //.replace("\"","");
            Literal_expression = java_literal_exp;
        }else if(java_literal_exp.contains("\'") && !variable_declaration_flag && !print_statement_flag){
            java_literal_exp = java_literal_exp;    //.replace("\'","");
            Literal_expression = java_literal_exp;
        }
        else{
            Literal_expression = java_literal_exp;
            print_statement_flag = false;
        }
        /** Soliman **/
        /* TODO: change the conditions to remove the quotes("\"|\'") only for the UI Components instead of specifying the ones not to remove from */
        /*if(ctx.literal().numeric_literal().Floating_point_literal()!= null)
        {
            literal_annotation = "Float";
        }
        else if(ctx.literal().numeric_literal().integer_literal()!= null){
            literal_annotation= "Int";
        }
        else if(ctx.literal().boolean_literal()!=null){
            literal_annotation = "Bool";
        }
        else if(ctx.literal().string_literal()!=null){
            literal_annotation = "String";
        }wdsadasdaw
         */
        return java_literal_exp;
    }
    //array part


    @Override
    public String visitArray_literal(Swift3Parser.Array_literalContext ctx) {
        String java_arr_literal ="";

        if(ctx.array_literal_items() != null)
            java_arr_literal += visitArray_literal_items(ctx.array_literal_items());

        return java_arr_literal ;
    }

    @Override
    public String visitArray_literal_items(Swift3Parser.Array_literal_itemsContext ctx) {
        String java_arr_literal_items ="";
        java_arr_literal_items+= visitArray_literal_item(ctx.array_literal_item());

        if(ctx.array_literal_items() != null) {
            java_arr_literal_items += ",";
            java_arr_literal_items += visitArray_literal_items(ctx.array_literal_items());

        }
        return java_arr_literal_items ;
    }

    /*---------------------------------------*/
    @Override
    public String visitDictionary_literal(Swift3Parser.Dictionary_literalContext ctx) {
     String java_dic_literal ="";

        dic_import_flag=true;//flag to add the import statements of hash map and map in dictionary

     if(ctx.dictionary_literal_items() != null) {
         java_dic_literal += visitDictionary_literal_items(ctx.dictionary_literal_items());

     }

    return java_dic_literal;
    }

    @Override
    public String visitDictionary_literal_items(Swift3Parser.Dictionary_literal_itemsContext ctx) {
        String java_dic_literal_items ="";

         visitDictionary_literal_item(ctx.dictionary_literal_item());
                //use array here
        if(!dic_key_array.contains(ctx.dictionary_literal_item().expression(0).getText())) { //by samer: the key is unique therefor we cannot repeat it so if the key is repeated so it won't be added
            dic_key_array.add(ctx.dictionary_literal_item().expression(0).getText());
            dic_value_array.add(ctx.dictionary_literal_item().expression(1).getText());
        }
       // System.out.println(dic_value_array);

       if(ctx.dictionary_literal_items() != null) {

            visitDictionary_literal_items(ctx.dictionary_literal_items());

       }
        return java_dic_literal_items ;
    }

    @Override
    public String visitDictionary_literal_item(Swift3Parser.Dictionary_literal_itemContext ctx) {
        String java_dic_literal_item ="";
        for(int i=0;i<2;i++) {//modification by samer: the for loop size is less than 2 to make sure that the array store only two dataTypes as we need the dataType of the key and value
            visitExpression(ctx.expression(i));


            if(dic_key_value_dataTypes_array.size() < 2)
            {
                if(literal_type == "int")
                    literal_type = "Integer";
                else if(literal_type == "float")
                    literal_type = "Float";
                else if(literal_type == "boolean")
                    literal_type = "Boolean";
                else if(literal_type == "double")
                    literal_type = "Double";
                else if(literal_type == "char")
                    literal_type = "Char";
                else if(literal_type == "long")
                    literal_type = "Long";


                dic_key_value_dataTypes_array.add(literal_type);

            }
        }


        java_dic_literal_item += ctx.getText();

        return java_dic_literal_item;
    }

    @Override
    public String visitParenthesized_expression(Swift3Parser.Parenthesized_expressionContext ctx) {
        String java_parenthesis = "";

        java_parenthesis += "("+visitExpression(ctx.expression())+")";

        return java_parenthesis;
    }

    @Override
    public String visitPostfix_operator(Swift3Parser.Postfix_operatorContext ctx) {
        String Java_operator="";
        Java_operator+=ctx.getText();

        return Java_operator;
    }

    @Override
    public String visitFunction_call_argument_clause(Swift3Parser.Function_call_argument_clauseContext ctx) {
        String Java_clause="";

        FunctionCall_flag = true;
        /** Soliman **/
        /* Checking if a Button with URL is detected and converting it */


        if(ctx.function_call_argument_list()!=null){
            if(!ctx.getText().contains("readLine()??")  )//modification by samer: to remove repeated nextLine( in boolean case

                Java_clause+=visitFunction_call_argument_list(ctx.function_call_argument_list());

        }

        if(Button_URL_flag){
//            System.out.println("1636"+ctx.getText());
            Button_URL_Link = ctx.getText().substring(ctx.getText().indexOf("\"")+1,ctx.getText().lastIndexOf("\""));
//            System.out.println(Button_URL_Link);
            Button_URL_isReady = true;
        }
        /** Soliman **/
        /* The line below was deleted because it used to return the URL before the button declaration while converting the Button_URL.
        * Might be deleted if it causes an error with other components */
        //Java_clause+=visitFunction_call_argument_list(ctx.function_call_argument_list());
        FunctionCall_flag = false;

        return Java_clause;
    }

    @Override
    public String visitFunction_call_argument_list(Swift3Parser.Function_call_argument_listContext ctx) {
        String Java_function_list ="";

        if(for_flag==1) {
            for_flag=0;

            String java_f1_expression = visitExpression(ctx.function_call_argument(0).expression());

            String java_f2_labelidentifier = ctx.function_call_argument(1).label_identifier().getText();
            String java_f2_expression = visitExpression(ctx.function_call_argument(1).expression());
            Swift3Parser.PrimaryContext pctx = (Swift3Parser.PrimaryContext) ctx.function_call_argument(2).expression().prefix_expression().postfix_expression();
            String java_f3_number = visitPrimary(pctx);
            Java_function_list +=  java_f1_expression + ";";
            Java_function_list += for_iterator;
            String great_or_less = "";
            String plus_or_minus = "";
            if (ctx.function_call_argument(2).expression().prefix_expression().prefix_operator() == null) {
                plus_or_minus += "+=";
                great_or_less += "<";
            } else {
                plus_or_minus += "-=";
                great_or_less += ">";

            }
            if (java_f2_labelidentifier.contains("to")) {
                Java_function_list += "" + great_or_less;
            } else if (java_f2_labelidentifier.contains("through")) {
                Java_function_list += great_or_less + "=";
            }
            Java_function_list += java_f2_expression + ";";
            Java_function_list += for_iterator + plus_or_minus + java_f3_number + ")";

        }
        else
        {
            if(ctx.function_call_argument()!=null)
            {

                if(Alert_flag) {

                    if (ctx.function_call_argument(0).label_identifier() != null) {
                        if (ctx.function_call_argument().size() > 1) {
                            String tmp = ctx.function_call_argument(1).label_identifier().getText();
                            if (tmp.contains("message")) {
                                Alert_message = visitExpression(ctx.function_call_argument(1).expression());
                                Alert_message = Alert_message.substring(1, Alert_message.length() - 1); //remove the double quotes
                                XMLAlertText = Alert_message;
                            }
                        }
                    }
                }
                if(Button_flag){

                    try {
                        if(ctx.function_call_argument(1).label_identifier() != null){
                            String attribute = ctx.function_call_argument(1).label_identifier().getText();
                            if(attribute.contains("action"))
                            {
                                Button_Action_Inprogress_wait_flag =true;
                                String tmp = visitExpression(ctx.function_call_argument(1).expression());
                                Java_function_list+=tmp;
//                                System.out.println(tmp);
                                if(tmp.contains("null")){//In this condition we check if the function call expression contains a function call to assigne it to the button.
                                    Button_Action = ctx.function_call_argument(1).expression().getText().replace("{","").replace("}","");
                                }else{
                                    Button_Action = visitExpression(ctx.function_call_argument(1).expression());
                                }
                            }

                        }
                    }catch (Exception e){
                        System.out.println("visitFunction_call_argument_list: Button_flag\n");
                    }
                }if(Switch_flag){

                    /** Soliman **/
                    /* Swift tracing statement: Toggle("Vibrate on Ring", isOn: $vibrateOnRing) */
                try {
                    if(ctx.function_call_argument(1).label_identifier() != null){
                        String attribute = ctx.function_call_argument(1).label_identifier().getText(); //Swift: isOn
                        String attribute_function = ctx.function_call_argument(1).expression().getText();//Swift: $vibrateOnRing
                        if(attribute.contains("isOn"))
                        {
                            Switch_Action_Inprogress_flag =true;
                            String counter_attribute_bool_state = "";//This variable shall be used to get the counter state of the boolean attribute
                            if(BooleanHM.containsKey(attribute_function.substring(1))){ //Here we check if the BooleanHM contains the key(vibrateOnRing) or not
                                String attribute_Identifier = attribute_function.substring(1); //vibrateOnRing
                                if(BooleanHM.get(attribute_function.substring(1)).contains("true")){//Checking if the boolean state in BooleanHM equals "true"
                                    counter_attribute_bool_state = "false";
                                }else if(BooleanHM.get(attribute_function.substring(1)).contains("false")){//Checking if the boolean state in BooleanHM equals "false"
                                    counter_attribute_bool_state = "true";
                                }
                                Switch_Action = attribute_Identifier+" = "+counter_attribute_bool_state+";";//Java: vibrateOnRing = true;
                            }else{
                                /** Soliman **/
                                /*TODO: try to find an alternative for this one */
                                /* Priority: LOW */
                                Switch_Action = visitExpression(ctx.function_call_argument(1).expression());// this is a temporary useless statement. leave it here though.

                            }
                        }
                    }
                }catch (Exception e){
                    System.out.println("visitFunction_call_argument_list: Switch_flag\n");
                }
            }
                if(ProgressBar_flag){
                    ProgressBarText = ctx.function_call_argument(0).expression().getText();
                    ProgressBar_Progress = ctx.function_call_argument(1).expression().getText();
                    ProgressBar_Max = ctx.function_call_argument(2).expression().getText();

                }
//            if(URL_flag){
//                    try {
//                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!##################");
//                    }catch (Exception e){
//                        System.out.println("visitFunction_call_argument_list: URL_flag\n");
//                    }
//            }

                if(insert_flag)
                {
                    // i deleted this line and it works why do we add it at the first place?
                    //Java_function_list += visitExpression(ctx.function_call_argument(1).expression())+",";
                    Java_function_list += visitExpression(ctx.function_call_argument(0).expression());
                    insert_flag=false;
                }
                else if(toastflag)
                {
                    toastflag=false;
                    Swift3Parser.Function_call_expressionContext toast=(Swift3Parser.Function_call_expressionContext) ctx.function_call_argument(1).expression().prefix_expression().postfix_expression();
                    Java_function_list+="getBaseContext(),"+toast.function_call_argument_clause().function_call_argument_list().getText()+", Toast.LENGTH_LONG";
                }
                else if(Intentflag)
                {
                    //Intentflag= false;
                    String s= ctx.function_call_argument(0).expression().getText();
                    Java_function_list+="this," +s.substring(s.indexOf("To")+2,s.indexOf("ID"))+".class";
                }
                else if(Old_URL_flag)
                {
                    for (int j = 0; j < ctx.function_call_argument().size(); j++) {
                        if (j == 0) {

                            Java_function_list += " "+visitExpression(ctx.function_call_argument(j).expression());
                            Java_function_list += " = new URL(\"";
                        }
                        else if (j==1)
                        {
                            String tmp = visitExpression(ctx.function_call_argument(j).expression());
                            Java_function_list += tmp.substring(tmp.indexOf("http"), tmp.indexOf(")")+1);
                        }

                    }
                    Old_URL_flag = false;
                }

                else {

                    for (int j = 0; j < ctx.function_call_argument().size(); j++) {

                        //modification by samer: to remove the extra space between the brackets of scanner.nextDouble() and its peer\
                        if(ctx.getText().contains("readLine()!") || ctx.getText().contains("readLine()??") ) {

                            Java_function_list += visitExpression(ctx.function_call_argument(j).expression());

                        }
                        else if(ctx.getText().contains("\\(")){ //by samer: to prevent the direct usage of the text inside the print statement while there is a variables inside
                            String whole_str="";//the holder of the whole text
                            String var_holder="";// the holder of the var name
                            String modified_Statement=""; // text_after modification
                            whole_str = ctx.getText().substring(1,ctx.getText().length()-1);
                            while(!whole_str.isEmpty())
                            {

                                 /* if (whole_str.startsWith("\"\\(")) {
                                      var_holder = ctx.getText().substring(3, ctx.getText().indexOf(")"));
                                      modified_Statement += var_holder;
                                      try {

                                          whole_str = whole_str.substring(whole_str.indexOf(")") + 1, whole_str.length());

                                      } catch (Exception e) {
                                          whole_str = "";
                                      }

                                      if (!whole_str.isEmpty())
                                          modified_Statement += " +";
                                  }*/

                                  if (whole_str.startsWith("\\(")) {
                                      var_holder = whole_str.substring(2, whole_str.indexOf(")"));
                                       if(key_value_for_tuple_flag)
                                       {

                                           if(var_holder.equals(key_value_for_tuple_array.get(0)) ) {

                                               var_holder = "entry.getKey()";
                                           }
                                           else if (var_holder.equals(key_value_for_tuple_array.get(1)) )
                                               var_holder = "entry.getValue()";
                                       }

                                      modified_Statement += var_holder;


                                      try {
                                          whole_str = whole_str.substring(whole_str.indexOf(")") + 1);

                                      } catch (Exception e) {
                                          whole_str = "";
                                      }

                                      if (!whole_str.isEmpty()) {

                                          modified_Statement += " +";
                                      }

                                  } else if(!whole_str.contains("\\(")){
                                      modified_Statement += "\""+whole_str+"\"";


                                      whole_str="";
                              }else {
                                      if (whole_str.contains("\\(")) {
                                          modified_Statement += "\"" + whole_str.substring(0, whole_str.indexOf("\\(")) + "\"+";
                                          whole_str = whole_str.substring(whole_str.indexOf("\\("));

                                      }

                                  }

                              }
                            if(key_value_for_tuple_flag == true)
                             key_value_for_tuple_flag= false;

                            Java_function_list= modified_Statement;
                        }
                        else {

                            Java_function_list += " " + visitExpression(ctx.function_call_argument(j).expression());

                        }

                        if (j != ctx.function_call_argument().size() - 1)
                            Java_function_list += ",";
                    }
                }
            }
        }

        return Java_function_list;
    }

    @Override
    public String visitFunction_call_argument(Swift3Parser.Function_call_argumentContext ctx)
    {
        String j_function_call_list =" " ;
        j_function_call_list = visitExpression(ctx.expression()) ;
        return j_function_call_list ;
    }
}
