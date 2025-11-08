package edu.farmingdale.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture; // For async Firestore operations
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import edu.farmingdale.library.model.Book;

public class LibraryService {

    private static final Firestore db = FirestoreClient.getFirestore();

    // Add a book
    public static void addBook(Book book) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> result = db.collection("books").document(String.valueOf(book.getID())).set(book);
        System.out.println("Book added at: " + result.get().getUpdateTime());
    }

    // Get a book by ID
    public static Book getBook(String id) throws ExecutionException, InterruptedException {
        DocumentReference docRef = db.collection("books").document(id);
        DocumentSnapshot doc = docRef.get().get();
        return doc.exists() ? doc.toObject(Book.class) : null;
    }

    // Update a book
    public static void updateBook(Book book) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> result = db.collection("books").document(String.valueOf(book.getID())).set(book);
        System.out.println("Book updated at: " + result.get().getUpdateTime());
    }

    // Delete a book
    public static void deleteBook(String id) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> result = db.collection("books").document(id).delete();
        System.out.println("Book deleted at: " + result.get().getUpdateTime());
    }

    // List all books
    public static List<Book> getAllBooks() throws ExecutionException, InterruptedException {
        ApiFuture<QuerySnapshot> future = db.collection("books").get();
        List<Book> books = new ArrayList<>();
        for (DocumentSnapshot doc : future.get().getDocuments()) {
            books.add(doc.toObject(Book.class));
        }
        return books;
    }
}
