package edu.depaul.ntessema.se457.research.hateoas.repository;

import edu.depaul.ntessema.se457.research.hateoas.model.Sage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.stream.Stream;

@Component
@Slf4j
public class SageLoader {

    private final SageRepository repository;

    @Autowired
    public SageLoader(SageRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void load() {
        log.info("In PostConstruct...");
        Stream.of(SAGES).forEach(s -> {
            Sage sage = new Sage();
            sage.setName(s[0]);
            sage.setLanguage(s[1]);
            sage.setSaidOn(s[3]);
            //repository.save(sage);
        });
    }

    private static final String[][] SAGES = new String[][] {
            {"Socrates","English","5ed31651b485c225bce82cbb","1928-10-26T04:18:53Z"},
            {"Chinese Proverb","Estonian","5ed31651b485c225bce82cbc","1809-12-02T08:33:26Z"},
            {"Abraham Lincoln","Kannada","5ed31651b485c225bce82cbd","1800-12-26T13:33:44Z"},
            {"Woody Allen","Kashmiri","5ed31651b485c225bce82cbe","1949-12-22T18:00:34Z"},
            {"Maimonides","Icelandic","5ed31651b485c225bce82cbf","1929-07-20T12:18:22Z"},
            {"Kevin Kruse","Dari","5ed31651b485c225bce82cc0","1927-07-27T01:43:29Z"},
            {"Napoleon Hill","Luxembourgish","5ed31651b485c225bce82cc1","1859-08-05T19:52:23Z"},
            {"Albert Einstein","Hiri Motu","5ed31651b485c225bce82cc2","1846-09-15T14:15:21Z"},
            {"Robert Frost","Kurdish","5ed31651b485c225bce82cc3","1830-08-16T08:12:13Z"},
            {"Florence Nightingale","Swati","5ed31651b485c225bce82cc4","1900-02-20T17:23:14Z"},
            {"Wayne Gretzky","New Zealand Sign Language","5ed31651b485c225bce82cc5","1874-08-19T06:31:17Z"},
            {"Michael Jordan","Hebrew","5ed31651b485c225bce82cc6","1831-02-08T11:54:22Z"},
            {"Amelia Earhart","Hungarian","5ed31651b485c225bce82cc7","1958-10-25T10:16:06Z"},
            {"Babe Ruth","Swedish","5ed31651b485c225bce82cc8","1910-08-30T16:13:15Z"},
            {"W. Clement Stone","Chinese","5ed31651b485c225bce82cc9","1846-09-04T10:51:20Z"},
            {"Kevin Kruse","Italian","5ed31651b485c225bce82cca","1929-12-08T22:19:44Z"},
            {"John Lennon","Hungarian","5ed31651b485c225bce82ccb","1854-10-28T07:09:19Z"},
            {"Earl Nightingale","Czech","5ed31651b485c225bce82ccc","1862-06-15T04:30:30Z"},
            {"Mark Twain","Kannada","5ed31651b485c225bce82ccd","1935-04-07T13:37:43Z"},
            {"Charles Swindoll","Hindi","5ed31651b485c225bce82cce","1811-11-09T08:53:39Z"},
            {"Alice Walker","Bulgarian","5ed31651b485c225bce82ccf","1833-10-16T09:09:46Z"},
            {"Buddha","Hungarian","5ed31651b485c225bce82cd0","1884-06-13T18:19:37Z"},
            {"Steve Jobs","Swati","5ed31651b485c225bce82cd1","1848-02-05T07:52:45Z"},
            {"Vince Lombardi","Malay","5ed31651b485c225bce82cd2","1882-01-02T16:46:04Z"},
            {"Stephen Covey","Malagasy","5ed31651b485c225bce82cd3","1953-07-16T05:14:28Z"},
            {"Pablo Picasso","Croatian","5ed31651b485c225bce82cd4","1913-03-29T06:51:01Z"},
            {"Christopher Columbus","Hiri Motu","5ed31651b485c225bce82cd5","1940-02-17T23:55:10Z"},
            {"Maya Angelou","Malagasy","5ed31651b485c225bce82cd6","1893-07-30T04:45:17Z"},
            {"Jim Rohn","Hebrew","5ed31651b485c225bce82cd7","1872-08-23T11:55:26Z"},
            {"Henry Ford","Sotho","5ed31651b485c225bce82cd8","1822-11-03T01:37:01Z"},
            {"Mark Twain","Catalan","5ed31651b485c225bce82cd9","1881-06-18T08:02:11Z"},
            {"Johann Wolfgang von Goethe","Tok Pisin","5ed31651b485c225bce82cda","1879-03-26T17:40:16Z"},
            {"Frank Sinatra","Irish Gaelic","5ed31651b485c225bce82cdb","1917-03-27T09:19:00Z"},
            {"Zig Ziglar","Oriya","5ed31651b485c225bce82cdc","1901-12-13T08:58:57Z"},
            {"Anais Nin","Macedonian","5ed31651b485c225bce82cdd","1950-09-19T12:12:46Z"},
            {"Vincent Van Gogh","Guaraní","5ed31651b485c225bce82cde","1874-03-05T23:45:05Z"},
            {"Aristotle","Hindi","5ed31651b485c225bce82cdf","1845-02-05T04:02:20Z"},
            {"Jesus","Northern Sotho","5ed31651b485c225bce82ce0","1838-04-15T04:02:47Z"},
            {"Ralph Waldo Emerson","Dhivehi","5ed31651b485c225bce82ce1","1868-04-13T02:15:38Z"},
            {"Henry David Thoreau","Lithuanian","5ed31651b485c225bce82ce2","1841-02-20T10:04:58Z"},
            {"Erma Bombeck","Sotho","5ed31651b485c225bce82ce3","1914-06-25T09:43:46Z"},
            {"Booker T. Washington","Yiddish","5ed31651b485c225bce82ce4","1936-08-29T02:29:32Z"},
            {" Ancient Indian Proverb","Yiddish","5ed31651b485c225bce82ce5","1832-09-05T21:52:38Z"},
            {"Theodore Roosevelt","Fijian","5ed31651b485c225bce82ce6","1930-03-10T10:57:07Z"},
            {"George Addair","German","5ed31651b485c225bce82ce7","1926-03-28T00:46:25Z"},
            {"Plato","Papiamento","5ed31651b485c225bce82ce8","1921-09-18T03:52:00Z"},
            {"Arthur Ashe","Tswana","5ed31651b485c225bce82ce9","1902-08-21T01:54:29Z"},
            {"John Lennon","Zulu","5ed31651b485c225bce82cea","1837-12-29T14:54:56Z"},
            {"Japanese Proverb","Amharic","5ed31651b485c225bce82ceb","1850-05-15T21:38:17Z"},
            {"Helen Keller","Tsonga","5ed31651b485c225bce82cec","1876-11-29T14:02:48Z"},
            {"Confucius","Icelandic","5ed31651b485c225bce82ced","1842-07-31T22:04:31Z"},
            {"Anne Frank","Pashto","5ed31651b485c225bce82cee","1836-12-14T03:09:39Z"},
            {"Lao Tzu","West Frisian","5ed31651b485c225bce82cef","1875-06-25T05:13:13Z"},
            {"Maya Angelou","Tamil","5ed31651b485c225bce82cf0","1941-04-16T14:56:36Z"},
            {"Dalai Lama","Filipino","5ed31651b485c225bce82cf1","1842-04-18T01:05:59Z"},
            {"Sheryl Sandberg","Malayalam","5ed31651b485c225bce82cf2","1903-02-15T02:58:51Z"},
            {"Aristotle","Romanian","5ed31651b485c225bce82cf3","1894-09-17T10:10:13Z"},
            {"Latin Proverb","Malay","5ed31651b485c225bce82cf4","1861-02-23T17:25:43Z"},
            {"Unknown","Burmese","5ed31651b485c225bce82cf5","1937-11-09T07:20:09Z"},
            {"Marie Curie","Sotho","5ed31651b485c225bce82cf6","1856-02-02T11:46:07Z"},
            {"Les Brown","Armenian","5ed31651b485c225bce82cf7","1841-12-08T08:51:20Z"},
            {"Joshua J. Marine","Finnish","5ed31651b485c225bce82cf8","1801-01-11T23:41:52Z"},
            {"Booker T. Washington","Oriya","5ed31651b485c225bce82cf9","1911-07-21T02:33:26Z"},
            {"Leonardo da Vinci","Bislama","5ed31651b485c225bce82cfa","1946-07-20T08:37:21Z"},
            {"Jamie Paolinetti","Malay","5ed31651b485c225bce82cfb","1906-09-14T05:00:30Z"},
            {"Erica Jong","Hindi","5ed31651b485c225bce82cfc","1918-06-06T08:25:08Z"},
            {"Bob Dylan","Somali","5ed31651b485c225bce82cfd","1922-10-12T10:17:27Z"},
            {"Benjamin Franklin","Lithuanian","5ed31651b485c225bce82cfe","1863-05-29T08:29:13Z"},
            {"Bill Cosby","French","5ed31651b485c225bce82cff","1874-10-11T22:50:58Z"},
            {" Albert Einstein","Oriya","5ed31651b485c225bce82d00","1950-04-19T08:25:59Z"},
            {"Chinese Proverb","Persian","5ed31651b485c225bce82d01","1888-03-16T07:08:04Z"},
            {"Roger Staubach","Punjabi","5ed31651b485c225bce82d02","1927-06-13T00:46:17Z"},
            {"George Eliot","Khmer","5ed31651b485c225bce82d03","1954-08-18T20:56:20Z"},
            {"Oprah Winfrey","Danish","5ed31651b485c225bce82d04","1930-06-08T21:58:43Z"},
            {"Vincent van Gogh","French","5ed31651b485c225bce82d05","1884-06-03T00:05:08Z"},
            {"Unknown","Kyrgyz","5ed31651b485c225bce82d06","1879-01-06T14:15:11Z"},
            {"Ann Landers","Arabic","5ed31651b485c225bce82d07","1800-06-24T15:59:57Z"},
            {"Abigail Van Buren","Dari","5ed31651b485c225bce82d08","1923-09-10T20:31:39Z"},
            {"Farrah Gray","Telugu","5ed31651b485c225bce82d09","1876-12-22T12:12:07Z"},
            {"Jesse Owens","Finnish","5ed31651b485c225bce82d0a","1897-12-10T01:01:41Z"},
            {"Sir Claus Moser","Yiddish","5ed31651b485c225bce82d0b","1904-05-14T10:15:35Z"},
            {"Rosa Parks","Indonesian","5ed31651b485c225bce82d0c","1897-09-07T00:35:36Z"},
            {"Confucius","Georgian","5ed31651b485c225bce82d0d","1949-09-05T12:18:32Z"},
            {"Oprah Winfrey","Khmer","5ed31651b485c225bce82d0e","1956-03-11T05:16:24Z"},
            {"Dalai Lama","Dhivehi","5ed31651b485c225bce82d0f","1897-09-02T06:07:17Z"},
            {"Maya Angelou","Dutch","5ed31651b485c225bce82d10","1856-05-23T04:46:29Z"},
            {"Norman Vaughan","Norwegian","5ed31651b485c225bce82d11","1872-02-05T16:20:42Z"},
            {"Martin Luther King Jr.","Malagasy","5ed31651b485c225bce82d12","1820-11-26T15:44:14Z"},
            {"Teddy Roosevelt","Māori","5ed31651b485c225bce82d13","1840-07-09T08:05:24Z"},
            {"Tony Robbins","Sotho","5ed31651b485c225bce82d14","1851-09-29T06:14:41Z"},
            {"Gloria Steinem","Māori","5ed31651b485c225bce82d15","1841-04-19T11:06:27Z"},
            {"Mae Jemison","Kyrgyz","5ed31651b485c225bce82d16","1870-02-25T00:45:48Z"},
            {"Beverly Sills","Khmer","5ed31651b485c225bce82d17","1892-09-04T08:11:45Z"},
            {"Eleanor Roosevelt","Armenian","5ed31651b485c225bce82d18","1920-07-05T23:59:07Z"},
            {"Grandma Moses","Tetum","5ed31651b485c225bce82d19","1892-08-14T19:58:13Z"},
            {"Ayn Rand","Belarusian","5ed31651b485c225bce82d1a","1923-04-27T07:50:04Z"},
            {"Henry Ford","Kannada","5ed31651b485c225bce82d1b","1948-11-22T07:22:47Z"},
            {"Norman Vincent Peale","Assamese","5ed31651b485c225bce82d1c","1897-11-13T11:04:38Z"},
            {"Benjamin Franklin","Czech","5ed31651b485c225bce82d1d","1893-12-29T16:38:09Z"},
            {"Audrey Hepburn","Afrikaans","5ed31651b485c225bce82d1e","1914-02-23T16:50:02Z"}
    };
}
