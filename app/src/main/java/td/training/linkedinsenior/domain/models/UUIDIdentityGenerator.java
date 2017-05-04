package td.training.linkedinsenior.domain.models;

import td.training.linkedinsenior.domain.IdentityGenerator;

import java.util.UUID;

/**
 * 20170423. Initial version created by jorge.
 */

public class UUIDIdentityGenerator implements IdentityGenerator {
    @Override
    public String getId() {
        return UUID.randomUUID().toString();
    }
}
