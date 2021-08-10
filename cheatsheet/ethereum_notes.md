# Useful links
[• Remix - Ethereum IDE](https://remix.ethereum.org/) 
<br />
[• A minimal ethereum javascript wallet (BIP-32-compatible)](https://github.com/ConsenSys/eth-lightwallet )
<br />
[• Ropsten Ethereum Faucet (testnet)](https://faucet.ropsten.be/)
<br /><br />
[• Mastering Ethereum book (GitHub)](https://github.com/ethereumbook/ethereumbook) 
<br />
[• ETH Gas Station | Consumer oriented metrics for the Ethereum gas market](https://www.ethgasstation.info) 
<br /><br />
[• ]() 
<br />

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
<i>Protecting the integrity of the address against typing or reading mistakes</i> (see: [validation](https://github.com/ethereumbook/ethereumbook/blob/develop/04keys-addresses.asciidoc#detecting-an-error-in-an-eip-55-encoded-address))
<br /><br />Capitalize each alphabetic address<sup>[1]</sup> character if the corresponding hex digit of the hash<sup>[2]</sup>  is **greater than or equal to 0x8**.<br/>
<br />[1] - Lowercase address, without the 0x prefix
<br />[2] - First 20 bytes of Keccak256 hash of the lowercase hexadecimal address

# Wallets
## Generating mnemonic words (and then seed)
1. **S** = Cryptographically random sequence of 128 to 256 bits.
2. **checksum** = n-first bits of the: SHA-256( S ), 
   where: <br />
   • n = length_of_s / 32
3. **sequence_and_checksum** = concatenation( S,https://github.com/ConsenSys/eth-lightwallet checksum )
4. Divide sequence_and_checksum into sections of 11 bits
5. **mnemonic_code** = sequence of words: each 11-bit value mapped to a word (one of 2048 words //**todo** link))
6. **seed** (512-bit) = PBKDF2( concatenation( mnemonic_code, **salt** )), where:<br />
   • PBKDF2 – key-stretching function<br />
   • salt – concatenation(  “mnemonic”, (optional)passphrase )


## HD wallet tree structure: <br />
m / purpose' / coin_type' / account' / change / address_index <br />
where: <br />
coin_type - type of cryptocurrency coin (see: [SLIP0044](https://github.com/satoshilabs/slips/blob/master/slip-0044.md))


--------------------
~ https://github.com/ethereumbook/ethereumbook/