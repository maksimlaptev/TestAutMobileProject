package helpers;

import com.github.javafaker.Faker;
import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * simple data generator
 */
@Getter
@FieldDefaults(level = AccessLevel.PUBLIC)
public class GeneratorData {
    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            middleName = faker.name().lastName(),
            company = faker.company().name(),
            email = faker.internet().emailAddress();
}
