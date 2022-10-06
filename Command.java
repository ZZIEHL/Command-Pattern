public abstract class Command {
    protected Document document;

    public Command(Document document)
    {

    }
    public abstract String execute();
     
    
}