package one.dao;

import one.model.Friends;
public interface friendsDaoInt {
      public void addfriends(Friends friends);
      public Friends findfriends1(String name);
      public void getfriends();
      public void deletefriends(String name);
}
