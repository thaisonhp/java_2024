package service.impl;

public interface Authentic {
    public boolean login(String username, String password);
    public boolean logout(String username, String password);
}
