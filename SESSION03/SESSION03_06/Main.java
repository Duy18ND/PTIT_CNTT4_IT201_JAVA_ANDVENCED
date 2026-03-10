package SESSION03.SESSION03_06;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static void main(String[] args) {
        Post post1 = new Post(Arrays.asList("Java","Backend"));
        Post post2 = new Post(Arrays.asList("C#","C++"));
        System.out.println("Bài viết về Java có: "+ post1.getTags());
        System.out.println("Bài viết về C có: "+ post2.getTags());

        List<Post> posts = Arrays.asList(post1,post2);

        List<String> flatmap = posts.stream().flatMap(post -> post.getTags().stream()).collect(Collectors.toList());

        System.out.println(flatmap);
    }
}
