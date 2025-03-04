import generatedantlr.Swift3Lexer;
import generatedantlr.Swift3Parser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.*;
import java.io.*;
import java.lang.Math;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {


        //file class
        ReadFile read = new ReadFile();
        String currentPath = new java.io.File(".").getCanonicalPath();
        System.out.println("Current dir:" + currentPath);
        //choose a file
        String swiftpath = "";

       swiftpath = read.chooseFile();

        //read a file
        String swiftCode = read.IosFileRead(swiftpath);

        /*
      String swiftCode =
              "\n" +
                      "import Foundation\n" +
                      "\n" +
                      "struct MemoryGame<CardContent> {\n" +
                      "    var cards: Array<Card>\n" +
                      "    \n" +
                      "    init(numberOfPairsOfCards: Int, cardContentFactory: (Int) -> CardContent) {\n" +
                      "        cards = Array<Card>()\n" +
                      "        for pairIndex in 0..<numberOfPairsOfCards {\n" +
                      "            let content = cardContentFactory(pairIndex)\n" +
                      "            cards.append(Card(content: content, id: pairIndex * 2))\n" +
                      "            cards.append(Card(content: content, id: pairIndex * 2 + 1))\n" +
                      "        }\n" +
                      "        cards = cards.shuffled()\n" +
                      "    }\n" +
                      "    \n" +
                      "    func choose(card: Card) {\n" +
                      "        print(\"card chosen: \\(card)\")\n" +
                      "    }\n" +
                      "    \n" +
                      "    struct Card: Identifiable {\n" +
                      "        var isFaceUp: Bool = true\n" +
                      "        var isMatched: Bool = false\n" +
                      "        var content: CardContent\n" +
                      "        var id: Int\n" +
                      "    }\n" +
                      "}"

              ;

*/
       //         "struct ContentView: View {\n" +
//                "    @State private var name: String = \"\"\n" +
//                "@State private var age:String = \"\"\n" +
//                "    @State private var fullText: String = \"This is some editable text...\"\n" +
//                "\t@state private var new: String = \"BLABLABLA\"\n" +
//                "\n" +
//                "    var body: some let View {        \t\n" +
//                "\t   TextField(\"Enter your name\", text: name)\n" +
//                "\t   TextField(\"What is your age\", text: age)\n" +
//                "\t   TextEditor(text: fullText)\n" +
//                "\t   TextEditor(text: new)\n" +
//                "           Link(\"LearnSwiftUI\", destination: URL(string: \"https://www.hackingwithswift.com/quick-start/swiftui\")!)\n" +
//                "\tLink(\"google\",destination: URL(string: \"https://www.google.com\")!)\n" +
//                "\t   Image(\"foo\")\n" +
//                "\tImage(\"sky\")\n" +
//                "           Alert(title: Text(\"Title of the alert\"), message: Text(\"Alert Example\"), dismissButton: .default(Text(\"OK\")))\n" +
//                "Alert(title: Text(\"Title of the alert\"), message: Text(\"Alert 2\"), dismissButton: .default(Text(\"OK\")))\t\n" +
//                "\t\t     \t\t\t\t        \n" +
//                "    }\n" +
//                "}";
//

        String javaCode = convertToJava(swiftCode);

        Path inputPath= Files.createTempFile("","input file.txt");
        Path outputPath= Files.createTempFile("","output file.txt");
        Path finaloutputPath= Files.createTempFile("","final output.txt.txt");

        //swift code
        BufferedWriter write = new BufferedWriter(new FileWriter("input file.txt"));
        write.write(swiftCode);
        write.close();
        write = new BufferedWriter(new FileWriter("output file.txt"));
        write.write(javaCode);
        write.close();

//python script and creating temporary files
        //Path path = Paths.get("temp/");


        String pythonCode = """
                #before running the code we must check whether a library is present or not
                import subprocess 
                import sys
                result = subprocess.run(["pip", "show", "google-generativeai"], capture_output=True, text=True)
                result_rust = subprocess.run(["rustc", "--version"], capture_output=True, text=True)
                if " is not recognized as an internal or external command" in result_rust.stderr:
                  print("\033[31mhere")
                  process = subprocess.Popen(
                      "curl -sSf https://sh.rustup.rs | sh",
                      shell=True,
                      stdin=subprocess.PIPE,
                      stdout=subprocess.PIPE,
                      stderr=subprocess.PIPE,
                      text=True
                  )
                  process.communicate(input="\\n\\n")
                     
                if len(result.stderr) !=0:
                  subprocess.run([sys.executable, "-m", "pip", "install", "-r", "requirements.txt"], check=True)
                  
                  #subprocess.run(["python", "-m", "pip", "install", "--upgrade", "pip", "setuptools", "wheel"], check=True)
                  #subprocess.check_call([sys.executable, "-m", "pip", "install", "google-generativeai"])
                
                  
                  print(result.stderr)
                #$ pip install google-generativeai
                import os
                import google.generativeai as genai
                import dotenv
                #AIzaSyB_sKDuWmC-qGmpPLf-WXp9nnvNIfCh_M8
                genai.configure(api_key='AIzaSyAXdrMSX5Z1TQeeUHNXp2FRCZBmBJAZMW4')

                generation_config = {
                  "temperature": 0.9,
                  "top_p": 1,
                  "max_output_tokens": 2048,
                  "response_mime_type": "text/plain",
                }

                model = genai.GenerativeModel(
                  model_name="gemini-2.0-pro-exp-02-05",
                  generation_config=generation_config,
                )

                currentDir = os.path.dirname(os.path.abspath(__file__))
                inputsDIR = "input file.txt"
                outputsDIR = "output file.txt"

                chat_session = model.start_chat(history=[])

                with open(inputsDIR, 'r') as inputs, open(outputsDIR, 'r') as outputs:
                    inputfile = inputs.read()
                    outputfile = outputs.read()

                response = chat_session.send_message(f"From now on act as a compiler, I am going to provide you with a code written in Language X alongside its translated code written in language Y generated by my trans-compiler tool. Your task is to carefully examine the translated code in language Y and fill in the code sections that are missing in Y but present in X. These missing sections will be indicated by #TCAIOSAC and if there is something wrong in the syntax of the code fix it. if you didn't find it and the code is fine, write the full code in the language y. write it without backticks and any other statements.do not forget to remove #TCAIOSAC. the first code is ```{inputfile}``` and the second code is ```{outputfile}```")

                with open("final output.txt", 'w') as final:
                    final.write(response.text)

                print(response.text)
                """;
        File requirements = File.createTempFile("requirements", ".txt");
        String required_dependencies = """
                google-generativeai
                python-dotenv
                """ ;
        try (FileWriter writer = new FileWriter(requirements)) {
            writer.write(required_dependencies);
        }catch (Exception e){
            System.err.println(e);
        }

        File tempScript = File.createTempFile("script", ".py");
        try (FileWriter writer = new FileWriter(tempScript)) {
            writer.write(pythonCode);
        }catch (Exception e){
            System.err.println(e);
        }

// Now execute the Python script
        ProcessBuilder processBuilder = new ProcessBuilder("python", tempScript.getAbsolutePath());
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        //ProcessBuilder builder = new ProcessBuilder("resources\\Python310\\python.exe", "resources\\gemini\\geminiVersion.py");
        //Process process = builder.start();



        System.out.println(System.getProperty("user.dir"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line,final_output="";
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            line+="\n";
            final_output+=line;
        }

        JOptionPane.showMessageDialog(null,final_output,"output",JOptionPane.PLAIN_MESSAGE);

        Files.delete(inputPath);
        Files.delete(outputPath);
        Files.delete(finaloutputPath);
        /*
        int exitCode = process.waitFor();
        System.out.println("Process exited with code: " + exitCode);

        BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String errorLine;
        while ((errorLine = errorReader.readLine()) != null) {
            System.err.println(errorLine);
        }
*/

        //System.out.println(javaCode);

        //create a file

        //read.IosFileWrite(javaCode);


        //System.out.println(s);

        String k="ami";
        ArrayList<String> x= new ArrayList<String>();
        x = new ArrayList<>();
        x.add("string1");
        x.add("string2");
        System.out.println();
        String temp = "gvhdg";
        String h;

        //System.out.println(temp[-1]);
        //h = temp[0];
    }

    private static String convertToJava(String swiftCode) {
        SwiftToJavaVisitor swiftToJavaVisitor = new SwiftToJavaVisitor();
        Swift3Parser parser = new Swift3Parser(null);
        ANTLRInputStream input = new ANTLRInputStream(swiftCode);
        Swift3Lexer lexer = new Swift3Lexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        parser.setInputStream(tokens);
        // from here u need to change your code

        ParseTree parseTree = parser.top_level();
        String javaCode = swiftToJavaVisitor.visitTop_level((Swift3Parser.Top_levelContext) parseTree);
        return javaCode;

    }
}
