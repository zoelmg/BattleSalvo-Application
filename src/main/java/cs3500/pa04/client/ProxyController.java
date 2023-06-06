package cs3500.pa04.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa04.controller.Controller;
import cs3500.pa04.model.Player;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.constant.Constable;
import java.net.Socket;

public class ProxyController implements Controller {
  private final Socket server;
  private final Player aiPlayer;
  private final InputStream in;
  private final OutputStream out;
  private final ObjectMapper mapper = new ObjectMapper();
  private static final JsonNode VOID_RESPONSE =
      new ObjectMapper().getNodeFactory().textNode("void");

  public ProxyController(Socket server, Player aiPlayer) throws IOException {
    this.server = server;
    this.aiPlayer = aiPlayer;
    this.in = server.getInputStream();
    this.out = server.getOutputStream();
  }


  @Override
  public void run() {

  }
}
