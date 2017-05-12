package service;

import dao.ElementDao;
import dao.ElementDaoImpl;

public class ElementServiceImpl {

    ElementDao elementDaoImpl;

    public String push(int i1, int i2) {
        elementDaoImpl = new ElementDaoImpl();
        elementDaoImpl.add(i1);
        elementDaoImpl.add(i2);

        return "ok";
    }

    public static void main(String[] args) {
        ElementDaoImpl elementDaoImpl = new ElementDaoImpl();
        elementDaoImpl.add(100);
    }
}
