package com.example.oopbee.business;

import com.example.oopbee.entity.Bee;
import com.example.oopbee.entity.Drone;
import com.example.oopbee.entity.QueenBee;
import com.example.oopbee.entity.WorkerBee;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * Logic class: create bee list, attack bee
 */
public class BeeHive {
    private List<Bee> listBee;  // Use List instead of ArrayList
    private static final SecureRandom rand = new SecureRandom(); // Use SecureRandom

    public void init() {
        // Create a list of 10 bees of Queen, Drone, and Worker types
        this.listBee = new ArrayList<>();

        this.listBee.add(new QueenBee());
        this.listBee.add(new WorkerBee());
        this.listBee.add(new Drone());

        for (int i = 0; i < 7; i++) {
            int r = rand.nextInt(3); // Generates 0, 1, or 2
            switch (r) {
                case 0 -> this.listBee.add(new QueenBee());
                case 1 -> this.listBee.add(new WorkerBee());
                case 2 -> this.listBee.add(new Drone());
            }
        }
    }

    public List<Bee> getAllBees() {  // Return List<Bee> instead of ArrayList<Bee>
        return listBee;
    }

    // Attack all bees
    public void attackBees() {
        for (Bee bee : listBee) {
            bee.damage();
        }
    }
}
