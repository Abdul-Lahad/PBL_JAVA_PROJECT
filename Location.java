import eu.bitm.NominatimReverseGeocoding.Address;
import eu.bitm.NominatimReverseGeocoding.NominatimReverseGeocodingJAPI;

public class Location {
    NominatimReverseGeocodingJAPI n1 = new NominatimReverseGeocodingJAPI(18);
    NominatimReverseGeocodingJAPI n2 = new NominatimReverseGeocodingJAPI(18);
    Address address;
    Database d = new Database();

    Object[] city_country(list lat, list lon, int Starting, int ending) {
        list ls = new list();
        list l = new list();
        list lis = new list();

        ls.head = new node("country");
        l.head = new node("city");
        lis.head = new node("state");

        node temp = ls.head, tem = l.head, temp3 = lis.head;

        node temp1 = lat.head.next, temp2 = lon.head.next;
        double t, o;
        int counter = 0;

        if (Starting > 1)
            for (int i = 1; i < Starting; i++) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }

        while (temp1 != null) {
            t = (Double) temp1.data;
            o = (Double) temp2.data;

            address = n2.getAdress(t, o);

            temp.next = new node(address.getCountry());
            System.out.print((++counter) + address.getCountry() + " ");
            
            tem.next = new node(address.getCity());
            System.out.print(address.getCity() + " ");
            
            temp3.next = new node(address.getState());
            System.out.print(address.getState() + " ");

            temp3 = temp3.next;
            temp = temp.next;
            tem = tem.next;
            temp1 = temp1.next;
            temp2 = temp2.next;

            Starting++;
            if (Starting == ending) {
                break;
            }
        }

        Object[] obj = { ls, l, lis };

        return obj;

    }

}
