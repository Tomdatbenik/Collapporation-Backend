package com.collapporation.gateway.utils;

import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class PemUtils {
    private static final Logger logger = LoggerFactory.getLogger(PemUtils.class);

    private PemUtils(){
        throw new IllegalStateException("Utility class");
    }

    private static byte[] parsePEMFile(File pemFile) throws IOException {
        try (final PemReader reader = new PemReader(new FileReader(pemFile))) {
            final PemObject pemObject = reader.readPemObject();
            return pemObject.getContent();
        }catch (Exception e){
            throw new FileNotFoundException(String.format("The file '%s' doesn't exist.", pemFile.getAbsolutePath()));
        }
    }

    private static PublicKey getPublicKey(byte[] keyBytes, String algorithm) {
        PublicKey publicKey = null;
        try {
            final KeyFactory kf = KeyFactory.getInstance(algorithm);
            final EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
            publicKey = kf.generatePublic(keySpec);
        } catch (NoSuchAlgorithmException e) {
            logger.error("Could not reconstruct the public key, the given algorithm could not be found.");
        } catch (InvalidKeySpecException e) {
            logger.error("Could not reconstruct the public key");
        }

        return publicKey;
    }

    public static PublicKey readPublicKeyFromFile(String filepath, String algorithm) throws IOException {
        final byte[] bytes = PemUtils.parsePEMFile(new File(filepath));
        return PemUtils.getPublicKey(bytes, algorithm);
    }
}
