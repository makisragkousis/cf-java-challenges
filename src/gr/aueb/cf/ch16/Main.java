package gr.aueb.cf.ch16;


public class Main {

    public static void main(String[] args) {
        Document aDoc = new Document("doc");
        Photo aPhoto = new Photo("photo");

//        Thread threadDoc = new Thread(() -> aDoc.print());
//        Thread threadPhoto = new Thread(() -> aPhoto.print());

        new Thread(aDoc::print).start();
        new Thread(aPhoto::print).start();
    }
}
