package gamelibrarycollection.com.gamelibrary;

import wrapper.IGDBWrapper;


class IGDBAPIClient {

    private final IGDBWrapper wrapper;

    public IGDBAPIClient(IGDBWrapper wrapper) {
        this.wrapper = wrapper;
    }

    public IGDBWrapper getWrapper() {
        return wrapper;
    }


}
