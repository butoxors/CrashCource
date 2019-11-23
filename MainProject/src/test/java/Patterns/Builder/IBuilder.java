package Patterns.Builder;

public interface IBuilder<T extends User> {
    void buildName();
    void buildEmail();
    T getResult();
}
