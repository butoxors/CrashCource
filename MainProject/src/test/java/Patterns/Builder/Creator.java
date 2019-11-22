package Patterns.Builder;

public class Creator<T extends  User> {
    private IBuilder<T> builder;

    public Creator(IBuilder<T> builder){
        this.builder = builder;
    }

    public void build(){
        builder.buildName();
        builder.buildEmail();
    }

    public T getResult(){
        return builder.getResult();
    }
}
