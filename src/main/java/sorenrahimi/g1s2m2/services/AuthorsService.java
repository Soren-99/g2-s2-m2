package sorenrahimi.g1s2m2.services;

import sorenrahimi.g1s2m2.entities.Author;
import sorenrahimi.g1s2m2.entities.BlogPost;
import sorenrahimi.g1s2m2.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class AuthorsService {
    private List<Author> authorsList = new ArrayList<>();
    public List<Author> getAuthorsList(){
        return this.authorsList;
    }
    public Author saveAuthor(Author body){
        Random rndm = new Random();
        body.setId(rndm.nextInt(1,10000));
        this.authorsList.add(body);
        return body;
    }

    public Author findById(int id){
        Author found = null;
        for (Author author: this.authorsList){
            if (author.getId() == id) found = author;
        }
        if (found == null) throw new NotFoundException(id);
        else return found;
    }
    public Author findByIdAndUpdate(int id, Author updateAuthor){
        Author found = null;
        for (Author author: this.authorsList){
            if (author.getId() == id) found = author;
            found.setNome(updateAuthor.getNome());
            found.setCognome(updateAuthor.getCognome());
            found.setEmail(updateAuthor.getEmail());
            found.setDataDiNascita(updateAuthor.getDataDiNascita());
            found.setAvatar(updateAuthor.getAvatar());

        }
        if (found == null) throw new NotFoundException(id);
        else return found;
    }
    public void findByIdAndDelete(int id){
        Iterator<Author> iterator = this.authorsList.iterator();
        while (iterator.hasNext()){
            Author current = iterator.next();
            if(current.getId() == id){
                iterator.remove();
            }
        }
    }
}
