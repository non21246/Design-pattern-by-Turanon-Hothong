package Building;

public class Houses {
    public static void main(String[] args) {
        House.Builder builder = new House.Builder();

        builder.foundation("Concrete")
                .structure("Brick")
                .roof("Tile")
                .furnished(true);

        House house = builder.build();

        System.out.println("Foundation: " + house.getFoundation());
        System.out.println("Structure: " + house.getStructure());
        System.out.println("Roof: " + house.getRoof());
        System.out.println("Furnished: " + house.isFurnished());
    }
}
