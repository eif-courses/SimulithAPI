package eif.viko.lt.simulith.webapp.config;

@FunctionalInterface
public
interface DropboxActionResolver<T> {
    T perform() throws Exception;
}