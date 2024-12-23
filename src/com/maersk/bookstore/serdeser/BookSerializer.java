package com.maersk.bookstore.serdeser;

import com.maersk.bookstore.entity.BookEntity;

import java.io.*;

public class BookSerializer {
    public static void serializeBook(BookEntity bookEntity) throws IOException {

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            fos = new FileOutputStream(bookEntity.getBookId()+".ser");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(bookEntity);

        } catch(IOException ex){
            ex.printStackTrace();

        }
        finally{
            oos.close();
            fos.close();
        }
    }

    public static BookEntity deSerializeBook(Long bookId) throws IOException {

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        BookEntity be=null;
        try{
            fis = new FileInputStream(bookId+".ser");
            ois = new ObjectInputStream(fis);
            be = (BookEntity)ois.readObject();

        } catch(ClassNotFoundException ex){
            ex.printStackTrace();
        } catch(FileNotFoundException ex){
            ex.printStackTrace();
        } catch(IOException ex){
            ex.printStackTrace();
        }
        finally{
            ois.close();
            fis.close();
        }
        return be;
    }
}
