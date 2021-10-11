package br.com.digitalschool.so;

import br.com.digitalschool.so.domain.Machine;
import br.com.digitalschool.so.domain.Streamer;
import br.com.digitalschool.so.repository.StreamerRepository;
import com.github.britooo.looca.api.core.Looca;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;

public class StreamerApp {
    public static void main(String[] args) throws UnknownHostException, SocketException {
        System.setProperty("java.net.preferIPv4Stack" , "true");
        System.out.println(Machine.getIpAddress());;
        System.out.println(Machine.getMacAdress());

        Looca looca = new Looca();

        List<Streamer> streamers = StreamerRepository.findByUsername("kennedy");
        streamers.forEach(System.out::println);
    }
}
