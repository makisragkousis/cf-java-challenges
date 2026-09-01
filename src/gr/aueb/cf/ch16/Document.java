package gr.aueb.cf.ch16;

public class Document implements IPrintable{
    private String doc;

    public Document() {}

    public Document(String doc) {
        this.doc = doc;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    @Override
    public void print() {
        System.out.println("Printing... " + doc);
    }
}
