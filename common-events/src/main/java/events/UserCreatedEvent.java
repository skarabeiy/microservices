package events;

public record UserCreatedEvent(
        Long userId,
        String email
) {
}
