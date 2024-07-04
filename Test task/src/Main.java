import java.time.Instant;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        DocumentManager manager = new DocumentManager();

        DocumentManager.Author author1 = DocumentManager.Author.builder()
                .id("1")
                .name("Author One")
                .build();

        DocumentManager.Author author2 = DocumentManager.Author.builder()
                .id("2")
                .name("Author Two")
                .build();

        DocumentManager.Document document1 = DocumentManager.Document.builder()
                .title("First Document")
                .content("This is the content of the first document.")
                .author(author1)
                .build();
        DocumentManager.Document savedDocument1 = manager.save(document1);

        DocumentManager.Document document2 = DocumentManager.Document.builder()
                .title("Second Document")
                .content("This is the content of the second document.")
                .author(author2)
                .build();
        DocumentManager.Document savedDocument2 = manager.save(document2);

        Test.testFindById(manager, savedDocument1.getId());
        Test.testSearchByTitlePrefix(manager, List.of("First"));
        Test.testSearchByContent(manager, List.of("second"));
        Test.testSearchByAuthorId(manager, List.of(author1.getId()));
        Test.testSearchByCreationDateRange(manager, Instant.now().minusSeconds(60), Instant.now());
    }
}
