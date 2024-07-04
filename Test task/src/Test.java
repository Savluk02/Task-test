import java.time.Instant;
import java.util.List;
import java.util.Optional;

public class Test {

    public static void testFindById(DocumentManager manager, String documentId) {
        Optional<DocumentManager.Document> foundDocument = manager.findById(documentId);
        System.out.println("Find by ID: " + foundDocument);
    }

    public static void testSearchByTitlePrefix(DocumentManager manager, List<String> titlePrefixes) {
        DocumentManager.SearchRequest searchRequest = DocumentManager.SearchRequest.builder()
                .titlePrefixes(titlePrefixes)
                .build();
        List<DocumentManager.Document> searchResults = manager.search(searchRequest);
        System.out.println("Search by title prefix: " + searchResults);
    }

    public static void testSearchByContent(DocumentManager manager, List<String> contents) {
        DocumentManager.SearchRequest searchRequest = DocumentManager.SearchRequest.builder()
                .containsContents(contents)
                .build();
        List<DocumentManager.Document> searchResults = manager.search(searchRequest);
        System.out.println("Search by content: " + searchResults);
    }

    public static void testSearchByAuthorId(DocumentManager manager, List<String> authorIds) {
        DocumentManager.SearchRequest searchRequest = DocumentManager.SearchRequest.builder()
                .authorIds(authorIds)
                .build();
        List<DocumentManager.Document> searchResults = manager.search(searchRequest);
        System.out.println("Search by author ID: " + searchResults);
    }

    public static void testSearchByCreationDateRange(DocumentManager manager, Instant from, Instant to) {
        DocumentManager.SearchRequest searchRequest = DocumentManager.SearchRequest.builder()
                .createdFrom(from)
                .createdTo(to)
                .build();
        List<DocumentManager.Document> searchResults = manager.search(searchRequest);
        System.out.println("Search by creation date range: " + searchResults);
    }
}
