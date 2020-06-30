# Email Encryption

## Motivation
Informally a spam email is an email which is not of
interest to the receiver. Everyday almost every one
of us finds hundreds of such spam emails waiting in
our in-boxes. A spammer (who sends spam emails)
generally has a business motive and most spam emails
try to advertise a product, a web-page or a service. If
the spam emails can be sent in a directed manner, i.e.,
if a spammer can send a specific advertisement to a
user who would be interested in it, then the motive
of the spammer would be successful to a large extent.
Thus, one of the important objectives of a spammer
would be to know the preferences or interests of the
users to whom it is sending the un-solicited messages.

In the context of emails, a solution to the problem of profiling attacks would be encrypting the communications so that the contents of the emails are not
available to the profiler. Or to make the communications anonymous so that given a message it would
not be possible for a profiler to trace the origin of the
message. In this paper we ask the following question:
What would be the exact security requirements for an
encryption scheme which can protect the communication from profilers? Intuitively a cipher obtained from
a secure encryption algorithm should not reveal any
information regarding the plaintext which was used to
produce the cipher. Hence, a secure encryption algorithm should surely resist attacks by profilers. But, as
the goal of a profiler is only to classify the messages,
it is possible that an encryption algorithm which provides security in a weaker sense would be enough to
resist profilers. We explore in this direction and try to
fix the appropriate security definition of an encryption
scheme which would provide security against profilers.

Using any encryption scheme involves the com
plicated machinery of key exchange (for symmetric
encryption) or a public key infrastructure (for asym
metric encryption). When the goal is just to protect
information against profilers the heavy machinery of
key exchange or public key infrastructure may be un
necessary. Keeping in mind security against profil
ers we propose a new protocol which does not require
explicit key exchange. To do this we use the notion
of CAPTCHAs, which are programs that can distin
guish between humans and machines by automated
Turing tests which are easy for humans to pass but
difficult for any machine. The use of CAPTCHAs
makes our protocol secure from non-human profilers,
but the protocol is still vulnerable to human adver
saries. In the context that we see the activity of pro
filing, it would be only profitable if a large number of
users can be profiled and this goal seems to be infea
sible if human profilers are employed for the task.
