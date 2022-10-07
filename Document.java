import java.lang.invoke.WrongMethodTypeException;
import java.util.ArrayList;

import command.FileManipulator;

public class Document {
    private String fileName;
    private ArrayList<String> lines;
    public Document(String fileName)
    {
        this.fileName = fileName;
        lines = FileManipulator.readFile(fileName);
    }
    public String view()
    {
        String data = "_________________\n\n";
        int count = 0;
        String spaces = LongestLine();
        while(count < lines.size())
        {
            data = data + "|     " + lines.get(count) + spaces + "|\n";
            count+=1;
        }
        data += "\n_________________\n";
        return data;
    }
    public String append(String line)
    {
        lines.add(line);
        return "The line has been appended to the document";
    }
    public String write(String line)
    {
        lines = new ArrayList<String>();
        lines.add(line);
        return "The line was written to the file";
    }
    public String save()
    {
        FileManipulator.writeFile(fileName, lines);
        return "The file has been saved.";
    }
    private String LongestLine()
    {
        int longest = 0;
        String space = "";
        int count = 0;
        while(count < lines.size())
        {
            if(lines.get(count).length() > longest)
            {
                longest = lines.get(count).length();
            }
        }
        count = 0;
        while(count < longest)
        {
            space += " ";
        }
        return space;
    }
}
