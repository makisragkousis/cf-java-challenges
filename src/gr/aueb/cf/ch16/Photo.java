package gr.aueb.cf.ch16;

public class Photo implements IPrintable{
    private String photo;

    public Photo() {}

    public Photo(String photo) {
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public void print() {
        System.out.println("Printing..." + photo);
    }
}
