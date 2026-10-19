
package splitwise;

import java.util.HashSet;
import java.util.Set;

public class Group {
    private final int id;
    private final String groupName;
    private final Set<User> users;

    public Group(int id, String groupName) {
        this.id = id;
        this.groupName = groupName;
        this.users = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }

    public Set<User> getUsers() {
        return Set.copyOf(users);
    }

    public boolean addUser(User user) {
        return users.add(user);
    }

    public boolean removeUser(User user) {
        return users.remove(user);
    }

    public boolean hasUser(User user) {
        return users.contains(user);
    }
}
