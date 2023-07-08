package client;

import com.beust.jcommander.Parameter;

public class Args {
    @Parameter(names = "-t")
    private String requestType;
    @Parameter(names =  "-i")
    private Integer index;
    @Parameter(names = "-m")
    private String message;

    public String resolve() {
        return requestType +
                (index == null ? "" : " " + index) +
                (message == null ? "" : " " + message);
    }

}