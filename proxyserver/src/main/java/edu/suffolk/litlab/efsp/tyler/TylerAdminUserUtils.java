package edu.suffolk.litlab.efsp.tyler;

import edu.suffolk.litlab.efsp.model.Name;
import edu.suffolk.litlab.efsp.model.Person;
import tyler.efm.latest.services.schema.common.UserType;
import tyler.efm.latest.services.schema.getuserrequest.GetUserRequestType;
import tyler.efm.latest.services.schema.getuserresponse.GetUserResponseType;

/** A class to hide the specific details of Tyler's return types */
public class TylerAdminUserUtils {

  public static Person getUser(TylerUserClient userPort, String userId) {
    GetUserRequestType req = new GetUserRequestType();
    req.setUserID(userId);
    GetUserResponseType resp = userPort.getUser(req);

    var user = resp.getUser();
    if (user == null) {
      user = new UserType();
    }

    Name name = new Name(user.getFirstName(), user.getMiddleName(), user.getLastName());
    // Okay calling test person here
    return Person.TestPerson(name, user.getEmail(), false);
  }
}
