package nl.han.oose.jellema.rick.servicelayer.services;

import nl.han.oose.jellema.rick.resourcelayer.ITokenDealer;

import java.util.UUID;
import java.util.function.Supplier;

public class TokenDealer implements ITokenDealer {
    private Supplier<UUID> uuidSupplier = UUID::randomUUID;
    @Override
    public String aquireToken(){
        return this.uuidSupplier.get().toString();
    }

}
