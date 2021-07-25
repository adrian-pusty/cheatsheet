# Elliptic Curve
**secp256k1 elliptic curve** ( see: [bitcoin-core
secp256k1]( https://github.com/bitcoin-core/secp256k1) )<br />
y<sup>2</sup> = (x<sup>3</sup> + 7) over (F<sub>p</sub>) <br />
or:<br />
y<sup>2</sup> mod p = (x<sup>3</sup> + 7) mod p<br/>
where:<br/>
**p** = 2<sup>256</sup> - 2<sup>32</sup> - 2<sup>9</sup> - 2<sup>8</sup> - 2<sup>7</sup> - 2<sup>6</sup> - 2<sup>4</sup> - 1
<br/>[Python example ("Mastering Ethereum")](https://github.com/ethereumbook/ethereumbook/blob/develop/04keys-addresses.asciidoc#using-python-to-confirm-that-this-point-is-on-the-elliptic-curve) <br/>

# Public Key
**K = k * G**<br />
where:<br />
**K** - Public key defined as the point: **K = (x, y)**<br />
**k** - Private key (random 256-bit number)<br />
**G** - Constant point (generator point - part of the secp256k1 standard)<br />
<b>*</b> - elliptic curve "multiplication" operator <br />

Serialization format:<br/>
**04 + x-coordinate** (32 bytes/64 hex) + **y-coordinate** (32 bytes/64 hex)<br/>
where:<br/>
**04** - Means it's an uncompressed point with 65 bytes length (counting prefix itself)

# Ethereum Address
Last 160 bits (20 least significant bytes)(optionally prefixed with <i>0x</i>) of:<br /> **Keccak256(K)**<br/>
where:<br/>
**K** - Public key (without <i>04</i> prefix)

Using **helpeth** command-line tool to generate: Address, ICAP Address and Public Key from Private Key:<br />
npm install -g helpeth <br />
helpeth keyDetails -p {address prefixed with 0x}

## Hex Encoding with Checksum in Capitalization
Capitalize each alphabetic address<sup>[1]</sup> character if the corresponding hex digit of the hash<sup>[2]</sup>  is **greater than or equal to 0x8**.<br/>
<br />[1] - Lowercase address, without the 0x prefix
<br />[2] - Keccak256 hash of the lowercase hexadecimal address

--------------------
https://github.com/ethereumbook/ethereumbook/