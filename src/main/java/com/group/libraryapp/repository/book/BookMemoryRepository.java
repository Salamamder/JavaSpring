package com.group.libraryapp.repository.book;


import org.springframework.stereotype.Repository;

@Repository
public class BookMemoryRepository implements BookRepository {
    // 메모리를 사용해서 저장하는 경우
    // private final List<Book> books = new ArrayList<Book>();

    public void saveBook() {
        // books.add(new Book());
        System.out.println("qMemoryRepository");
    }
}