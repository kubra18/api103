package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class GoRestPojo2 {
    // {
    //        "meta": null,
    //        "data": {
    //            "id": 247158,
    //            "name": "Chandak Dutta",
    //            "email": "dutta_chandak@bartoletti.name",
    //            "gender": "female",
    //            "status": "inactive"
    //        }
    //    }

    private Object meta;
    private GoRestDataPojo2 data;

    public GoRestPojo2() {
    }

    public GoRestPojo2(Object meta, GoRestDataPojo2 data) {
        this.meta = meta;
        this.data = data;
    }

    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }

    public GoRestDataPojo2 getData() {
        return data;
    }

    public void setData(GoRestDataPojo2 data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "GoRestPojo2{" +
                "meta=" + meta +
                ", data=" + data +
                '}';
    }
}