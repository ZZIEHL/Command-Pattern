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
        String data = "_________________\n";
        int count = 0;
        while(count < lines.size())
        {
            data = data + "|\t" + lines.get(count) + "\t|\n";
        }
        data += "_________________\n";
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
}
